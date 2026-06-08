/*
 * 485. Max Consecutive Ones  (Easy)
 *
 * Approach: linear scan with a running streak counter; reset on 0.
 *
 * Time: O(n)   Space: O(1)
 */
class Solution {
    fun findMaxConsecutiveOnes(nums: IntArray): Int {
        var best = 0
        var streak = 0
        for (x in nums) {
            if (x == 1) {
                streak++
                if (streak > best) best = streak
            } else {
                streak = 0
            }
        }
        return best
    }
}
