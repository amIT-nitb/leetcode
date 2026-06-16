/*
 * 80. Remove Duplicates from Sorted Array II  (Medium)
 *
 * Approach: same slow/fast pattern as #26, with the comparison shifted back
 *   two slots so each value can be kept up to twice.
 *
 *   Invariant: nums[0..k-1] is the deduped (each-at-most-twice) prefix.
 *   When deciding whether to keep nums[i], we compare it against nums[k-2]:
 *     - if nums[i] != nums[k-2], it's safe to keep — at most one prior copy
 *       (nums[k-1]) can equal it, so keeping nums[i] gives at most two.
 *     - if nums[i] == nums[k-2], we'd be writing a third copy — skip.
 *   The first two slots are always safe to keep, so start k at 2.
 *
 *   nums = [0,0,1,1,1,1,2,3,3]
 *           ^k=2
 *   i=2 (1) vs nums[0]=0  -> keep, write nums[2]=1, k=3
 *   i=3 (1) vs nums[1]=0  -> keep, write nums[3]=1, k=4    (now [0,0,1,1])
 *   i=4 (1) vs nums[2]=1  -> SKIP   (would be 3rd 1)
 *   i=5 (1) vs nums[2]=1  -> SKIP
 *   i=6 (2) vs nums[2]=1  -> keep, k=5
 *   i=7 (3) vs nums[3]=1  -> keep, k=6
 *   i=8 (3) vs nums[4]=2  -> keep, k=7
 *   prefix = [0,0,1,1,2,3,3], k=7
 *
 * Time: O(n)   Space: O(1)
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length;
        int k = 2;                                   // first two are always kept
        for (int i = 2; i < nums.length; i++) {
            // compare to nums[k-2]: if different, this would be the 1st or 2nd copy
            if (nums[i] != nums[k - 2]) {
                nums[k++] = nums[i];
            }
        }
        return k;
    }
}
