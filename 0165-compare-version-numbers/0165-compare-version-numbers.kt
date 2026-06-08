/*
 * 165. Compare Version Numbers  (Medium)
 *
 * Approach: split on '.', compare component-by-component as integers.
 *   Iterate to the longer length; treat missing components as 0 so
 *   "1.0" equals "1.0.0.0". toInt() naturally handles leading zeros.
 *
 *      v1 = "1.01"     -> [1, 1]
 *      v2 = "1.001.5"  -> [1, 1, 5]
 *      i=2: missing(0) vs 5 -> v2 wins
 *
 * Time: O(n + m)   Space: O(n + m)
 */
class Solution {
    fun compareVersion(version1: String, version2: String): Int {
        val a = version1.split(".")
        val b = version2.split(".")
        // walk to the LONGER length so missing tail components compare as 0
        for (i in 0 until maxOf(a.size, b.size)) {
            val x = if (i < a.size) a[i].toInt() else 0
            val y = if (i < b.size) b[i].toInt() else 0
            if (x != y) return if (x > y) 1 else -1
        }
        return 0
    }
}
