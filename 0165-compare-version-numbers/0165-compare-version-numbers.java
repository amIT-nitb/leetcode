class Solution {
    public int compareVersion(String version1, String version2) {
        String[] arrVersion1 = version1.split("\\.");
        String[] arrVersion2 = version2.split("\\.");
        
    
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