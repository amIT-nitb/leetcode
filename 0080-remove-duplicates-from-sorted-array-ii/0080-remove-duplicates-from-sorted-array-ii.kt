/*
 * 80. Remove Duplicates from Sorted Array II  (Medium)
 *
 * Approach: same slow/fast pattern as #26 but compare against nums[k-2].
 *   If nums[i] != nums[k-2], keeping it produces at most two copies (the prior
 *   copy is at k-1). If equal, writing would be the 3rd copy — skip.
 *
 *   nums = [0,0,1,1,1,1,2,3,3]   ->   prefix [0,0,1,1,2,3,3], k=7
 *
 * Time: O(n)   Space: O(1)
 */
class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        if (nums.size <= 2) return nums.size
        var k = 2
        for (i in 2 until nums.size) {
            if (nums[i] != nums[k - 2]) {
                nums[k++] = nums[i]
            }
        }
        return k
    }
}
