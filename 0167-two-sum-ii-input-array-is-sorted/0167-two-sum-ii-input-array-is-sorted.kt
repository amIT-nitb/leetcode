/*
 * 167. Two Sum II - Input Array Is Sorted  (Medium)
 *
 * Approach: opposing two pointers on the sorted array.
 *   l=0, r=n-1. sum>target -> r--, sum<target -> l++, equal -> done.
 *   O(1) space since the sorted invariant lets us skip pairs we've already
 *   proven worse than achievable.
 *
 *   Result is 1-indexed per the problem.
 *
 * Time: O(n)   Space: O(1)
 */
class Solution {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var l = 0
        var r = numbers.size - 1
        while (l < r) {
            val sum = numbers[l] + numbers[r]
            when {
                sum < target -> l++
                sum > target -> r--
                else -> return intArrayOf(l + 1, r + 1)   // 1-indexed
            }
        }
        return intArrayOf()
    }
}
