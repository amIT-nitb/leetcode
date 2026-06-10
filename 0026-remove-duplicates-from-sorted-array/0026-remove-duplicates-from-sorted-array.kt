/*
 * 26. Remove Duplicates from Sorted Array  (Easy)
 *
 * Approach: slow/fast two-pointer dedup. k = count of uniques seen so far.
 *   Walk i from 1; when nums[i] != nums[k-1], it's a new unique — write it.
 *
 *   nums = [0,0,1,1,1,2,2,3,3,4]
 *   end:  prefix [0,1,2,3,4], k=5
 *
 * Time: O(n)   Space: O(1)
 */
class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        var k = 1
        for (i in 1 until nums.size) {
            if (nums[i] != nums[k - 1]) {
                nums[k++] = nums[i]
            }
        }
        return k
    }
}
