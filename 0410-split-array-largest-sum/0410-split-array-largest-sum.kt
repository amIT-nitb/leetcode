/*
 * 410. Split Array Largest Sum  (Hard)
 *
 * Approach: binary search on the ANSWER value.
 *   lo = max(nums)  (must hold one largest element)
 *   hi = sum(nums)  (m=1 case)
 *   For candidate cap `mid`, greedily count how many subarrays we'd need so
 *   that none exceeds `mid`. If <= m, cap is feasible -> try smaller. If > m,
 *   cap is too tight -> try larger.
 *
 *   mid = lo + (hi - lo) / 2 to avoid int overflow on (lo + hi).
 *
 * Time: O(n * log(sum - max))   Space: O(1)
 */
class Solution {
    fun splitArray(nums: IntArray, m: Int): Int {
        if (nums.isEmpty() || m == 0) return 0
        var max = 0
        var sum = 0
        for (x in nums) { sum += x; if (x > max) max = x }
        if (m == nums.size) return max
        if (m == 1) return sum

        var lo = max
        var hi = sum
        var ans = 0
        while (lo <= hi) {
            val mid = lo + (hi - lo) / 2   // overflow-safe midpoint
            if (canPartition(nums, mid, m)) {
                ans = mid
                hi = mid - 1   // feasible -> seek smaller cap
            } else {
                lo = mid + 1   // infeasible -> need larger cap
            }
        }
        return ans
    }

    private fun canPartition(nums: IntArray, cap: Int, m: Int): Boolean {
        var subarrays = 1
        var running = 0
        for (x in nums) {
            running += x
            if (running > cap) {
                // start a new subarray HERE; no benefit to splitting earlier
                subarrays++
                running = x
            }
        }
        return subarrays <= m
    }
}
