/*
 * 3. Longest Substring Without Repeating Characters  (Medium)
 *
 * Approach: sliding window with "last seen index" map.
 *   Maintain [start..i] as the candidate window. Each char's most recent index
 *   lives in the map. When we hit a duplicate INSIDE the window (lastSeen >= start),
 *   jump start past it. Otherwise the duplicate is stale (already outside the
 *   window) and we ignore it.
 *
 *      s: t m m z u x t
 *      i: 0 1 2 3 4 5 6
 *           ^ start jumps here when 2nd 'm' hits (lastSeen=1, +1)
 *                       ^ at 2nd 't': lastSeen('t')=0+1=1, but start=2 wins
 *
 * Time: O(n)   Space: O(min(n, alphabet))
 */
class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        var best = 0
        var start = 0
        val lastSeen = HashMap<Char, Int>()
        for (i in s.indices) {
            val c = s[i]
            val prev = lastSeen[c]
            // only jump if the duplicate is INSIDE the current window
            if (prev != null && prev >= start) {
                start = prev + 1
            }
            lastSeen[c] = i
            best = maxOf(best, i - start + 1)
        }
        return best
    }
}
