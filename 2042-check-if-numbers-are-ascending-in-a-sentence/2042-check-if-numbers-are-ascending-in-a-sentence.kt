/*
 * 2042. Check if Numbers Are Ascending in a Sentence  (Easy)
 *
 * Approach: split on spaces, parse each token as int (ignore words via
 * toIntOrNull). Each numeric token must be STRICTLY greater than the prior
 * numeric token. prev = -1 lets the first number always pass.
 *
 * Time: O(n)   Space: O(n)
 */
class Solution {
    fun areNumbersAscending(s: String): Boolean {
        var prev = -1
        for (token in s.split(" ")) {
            val num = token.toIntOrNull() ?: continue   // word -> skip
            if (num <= prev) return false               // strict ascending; equal fails
            prev = num
        }
        return true
    }
}
