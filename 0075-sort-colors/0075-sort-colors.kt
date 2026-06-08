/*
 * 75. Sort Colors  (Medium)
 *
 * Approach: Dutch National Flag — three pointers, one pass, in place.
 *   Regions:  [0..low-1]=0s  [low..mid-1]=1s  [mid..high]=unknown  [high+1..]=2s
 *
 *      0 0 0 | 1 1 1 | ? ? ? ? | 2 2
 *            ^ low   ^ mid    ^ high
 *
 *   Inspect nums[mid]:
 *     0 -> swap(low, mid); low++; mid++  (swapped-in was a 1, already classified)
 *     1 -> mid++
 *     2 -> swap(mid, high); high--       (do NOT advance mid: incoming is unknown)
 *
 * Time: O(n)   Space: O(1)
 */
class Solution {
    fun sortColors(nums: IntArray) {
        var low = 0
        var mid = 0
        var high = nums.size - 1
        while (mid <= high) {
            when (nums[mid]) {
                0 -> { swap(nums, low++, mid++) }
                1 -> { mid++ }
                2 -> { swap(nums, mid, high--) }   // mid stays put; re-inspect next loop
            }
        }
    }

    private fun swap(a: IntArray, i: Int, j: Int) {
        val t = a[i]; a[i] = a[j]; a[j] = t
    }
}
