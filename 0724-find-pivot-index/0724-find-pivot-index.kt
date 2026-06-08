/*
 * 724. Find Pivot Index  (Easy)
 *
 * Approach: prefix-sum, two passes.
 *   total = sum(nums). Walk i carrying leftSum; pivot condition rearranges to
 *   2 * leftSum + nums[i] == total.
 *
 * Time: O(n)   Space: O(1)
 */
class Solution {
    fun pivotIndex(nums: IntArray): Int {
        var total = 0
        for (x in nums) total += x
        var leftSum = 0
        for (i in nums.indices) {
            // leftSum == total - leftSum - nums[i]   <=>   2*leftSum + nums[i] == total
            if (leftSum == total - leftSum - nums[i]) return i
            leftSum += nums[i]
        }
        return -1
    }
}
