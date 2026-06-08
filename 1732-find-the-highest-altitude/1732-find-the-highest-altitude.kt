/*
 * 1732. Find the Highest Altitude  (Easy)
 *
 * Approach: running prefix sum, track max. Starting altitude is 0, which is
 * the floor — answer can't be negative.
 *
 * Time: O(n)   Space: O(1)
 */
class Solution {
    fun largestAltitude(gain: IntArray): Int {
        var altitude = 0
        var max = 0
        for (g in gain) {
            altitude += g
            if (altitude > max) max = altitude
        }
        return max
    }
}
