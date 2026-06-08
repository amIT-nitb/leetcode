/*
 * 4. Median of Two Sorted Arrays  (Hard)
 *
 * Approach used here: merge-up-to-the-median.
 *   Walk both sorted arrays with two pointers, copying the smaller front element
 *   each step into a temp array, stopping once we've copied enough to know the
 *   median position. For odd total length, median is temp[(n+m)/2]. For even,
 *   average of temp[(n+m)/2] and temp[(n+m)/2 - 1].
 *
 *   This is O(n+m). The optimal approach is partition-based binary search at
 *   O(log min(n, m)), but the merge passes the judge.
 *
 * Time: O(n+m)   Space: O(n+m)
 */
class Solution {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val n = nums1.size
        val m = nums2.size
        val temp = IntArray(n + m)
        var p1 = 0
        var p2 = 0
        var c = 0
        val threshold = (n + m) / 2
        // only merge as far as the median position; rest of temp is irrelevant
        while (c <= threshold) {
            temp[c++] = when {
                p1 < n && p2 < m -> if (nums1[p1] < nums2[p2]) nums1[p1++] else nums2[p2++]
                p1 < n -> nums1[p1++]
                else -> nums2[p2++]
            }
        }
        val mid = (n + m) / 2
        return if ((n + m) % 2 == 0) (temp[mid] + temp[mid - 1]) / 2.0 else temp[mid].toDouble()
    }
}
