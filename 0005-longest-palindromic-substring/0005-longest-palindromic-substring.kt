/*
 * 5. Longest Palindromic Substring  (Medium)
 *
 * Approach used here: shrink-from-largest brute force.
 *   Try substring lengths from n down to 1. For each length, try every starting
 *   index. Return as soon as one is a palindrome — by construction it's the
 *   longest. Early termination saves work when the answer is long.
 *
 *   Optimal alternatives: O(n^2) expand-around-center, O(n) Manacher's. This
 *   solution is O(n^3) worst case but accepts on LeetCode for moderate input.
 *
 * Time: O(n^3) worst   Space: O(1)
 */
class Solution {
    fun longestPalindrome(s: String): String {
        for (len in s.length downTo 1) {
            for (j in 0..s.length - len) {
                // first palindrome at this length is the longest possible answer
                if (isPalindrome(s, j, j + len)) return s.substring(j, j + len)
            }
        }
        return ""
    }

    private fun isPalindrome(s: String, lo: Int, hiExclusive: Int): Boolean {
        var i = lo
        var j = hiExclusive - 1
        while (i < j) {
            if (s[i] != s[j]) return false
            i++; j--
        }
        return true
    }
}
