/*
 * 88. Merge Sorted Array  (Easy)
 *
 * Approach: write from the back. The trailing zeros in nums1 are the natural
 *   scratch space; walking i, j right-to-left into a write head w means we
 *   never overwrite an un-merged nums1 value.
 *
 *   nums1 = [1,2,3,0,0,0] m=3   nums2 = [2,5,6] n=3
 *           i=2   j=2 w=5  ->  6 wins, place at w=5
 *           i=2   j=1 w=4  ->  5 wins, place at w=4
 *           ... continues until j < 0
 *
 * Time: O(m + n)   Space: O(1)
 */
class Solution {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        var i = m - 1
        var j = n - 1
        var w = m + n - 1
        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[w--] = nums1[i--]
            } else {
                nums1[w--] = nums2[j--]
            }
        }
    }
}
