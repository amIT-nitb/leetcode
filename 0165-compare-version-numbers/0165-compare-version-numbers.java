/*
 * 165. Compare Version Numbers  (Medium)
 *
 * Approach: split on '.', compare component-by-component as integers.
 *   Iterate up to the longer of the two version arrays. When one version runs
 *   out of components, treat the missing tail as 0 (so "1.0" == "1.0.0.0").
 *   Parsing each chunk via Integer.parseInt naturally handles leading zeros
 *   ("01" == 1).
 *
 *      v1 = "1.01"      -> [1, 1]
 *      v2 = "1.001.5"   -> [1, 1, 5]
 *      i=0: 1 vs 1 ✓     i=1: 1 vs 1 ✓     i=2: 0 (missing) vs 5 -> v2 wins
 *
 *   The split regex needs "\\." because '.' is a regex metachar.
 *
 * Time: O(n + m)   Space: O(n + m) for the split arrays
 */
class Solution {
    public int compareVersion(String version1, String version2) {
        String[] arrVersion1 = version1.split("\\.");
        String[] arrVersion2 = version2.split("\\.");
        // iterate to the LONGER length so missing tail components compare as 0
        for (int i = 0; i < Math.max(arrVersion1.length, arrVersion2.length); i++) {
            if(i >= arrVersion1.length && i <= arrVersion2.length) {
                if(Integer.parseInt(arrVersion2[i]) > 0) {
                    return -1;
                }
            }
            else if(i >= arrVersion2.length && i <= arrVersion1.length) {
                if(Integer.parseInt(arrVersion1[i]) > 0) {
                    return 1;
                }
            }
            else {
                if(Integer.parseInt(arrVersion1[i]) > Integer.parseInt(arrVersion2[i])) {
                    return 1;
                }
                else if(Integer.parseInt(arrVersion1[i]) < Integer.parseInt(arrVersion2[i])) {
                    return -1;
                }
            }
        }

        return 0;
    }
        
        
        
        
    
}