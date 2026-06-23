/*
 * 88. Merge Sorted Array  (Easy)
 *
 * Approach: write from the back.
 *   The trailing zeros in nums1 are the natural scratch space. Walk i over the
 *   real prefix of nums1, j over nums2, and a write pointer w from the very
 *   end. At each step, place the larger of nums1[i] / nums2[j] at nums1[w].
 *   Going right-to-left avoids overwriting un-merged values in nums1.
 *
 *   nums1 = [1, 2, 3, 0, 0, 0]   m=3
 *   nums2 = [2, 5, 6]            n=3
 *
 *           i=2     j=2  w=5     6 > 3 -> place 6 at w=5
 *   nums1 = [1, 2, 3, 0, 0, 6]
 *           i=2     j=1  w=4     5 > 3 -> place 5 at w=4
 *   nums1 = [1, 2, 3, 0, 5, 6]
 *           ... continues until j < 0
 *
 *   Once j < 0, anything left in nums1[0..i] is already in place (sorted prefix).
 *   If i runs out first, the remaining nums2 entries copy straight into the front.
 *
 * Time: O(m + n)   Space: O(1)
 */
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;          // last real value in nums1
        int j = n - 1;          // last value in nums2
        int w = m + n - 1;      // write head at the very end of nums1
        while (j >= 0) {
            // if nums1 still has values AND its tail is bigger, take from nums1
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[w--] = nums1[i--];
            } else {
                nums1[w--] = nums2[j--];
            }
        }
        // no need to drain nums1 — its remaining prefix is already correctly placed
    }
}
