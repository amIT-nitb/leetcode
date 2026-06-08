/*
 * 875. Koko Eating Bananas  (Medium)
 *
 * Approach: binary search on speed k.
 *   hoursAt(k) = sum(ceil(p / k)) is monotonically non-increasing in k.
 *   Find smallest k with hoursAt(k) <= h.
 *
 *   low=1, high=max(piles) (no benefit beyond max pile -> 1hr/pile).
 *   Special case h == n: must finish every pile in 1hr -> answer = max(piles).
 *
 *   Use integer ceil ((p + k - 1) / k) to avoid floating point.
 *
 * Time: O(n * log(max))   Space: O(1)
 */
class Solution {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        val n = piles.size
        var max = 0
        for (p in piles) if (p > max) max = p
        if (h == n) return max

        var lo = 1
        var hi = max
        while (lo < hi) {
            val mid = lo + (hi - lo) / 2
            var hours = 0L
            for (p in piles) hours += (p + mid - 1L) / mid   // integer ceil
            if (hours <= h) hi = mid       // fits -> try smaller
            else lo = mid + 1              // too slow -> need faster
        }
        return lo
    }
}
