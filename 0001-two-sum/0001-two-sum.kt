/*
 * 1. Two Sum  (Easy)
 *
 * Approach: single-pass hash map.
 *   For each element, ask "have I already seen its complement (target - x)?"
 *   If yes -> we have the pair. If no -> remember the current element so a
 *   future iteration can find it. One pass; the map IS the memory.
 *
 * Time: O(n)   Space: O(n)
 */
class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = HashMap<Int, Int>()
        for (i in nums.indices) {
            val comp = target - nums[i]
            // check BEFORE inserting: prevents matching nums[i] against itself
            map[comp]?.let { return intArrayOf(i, it) }
            map[nums[i]] = i
        }
        return intArrayOf()
    }
}
