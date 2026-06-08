/*
 * 8. String to Integer (atoi)  (Medium)
 *
 * Approach: three explicit phases.
 *   1. Skip leading whitespace.
 *   2. Read at most ONE optional sign (+ or -).
 *   3. Read digits, accumulating with overflow guard BEFORE each multiply.
 *      MAX_VALUE/10 = 214748364 (last digit 7). Bail to MIN/MAX accordingly.
 *
 * Time: O(n)   Space: O(1)
 */
class Solution {
    fun myAtoi(s: String): Int {
        val len = s.length
        var i = 0
        // 1. skip leading whitespace
        while (i < len && s[i] == ' ') i++
        // 2. optional single sign
        var negative = false
        if (i < len) {
            if (s[i] == '+') i++
            else if (s[i] == '-') { negative = true; i++ }
        }
        // 3. accumulate digits
        var result = 0L
        while (i < len) {
            val d = s[i] - '0'
            if (d !in 0..9) break
            // overflow check BEFORE the multiply
            if (result > Int.MAX_VALUE / 10 || (result == (Int.MAX_VALUE / 10).toLong() && d > 7)) {
                return if (negative) Int.MIN_VALUE else Int.MAX_VALUE
            }
            result = result * 10 + d
            i++
        }
        return (if (negative) -result else result).toInt()
    }
}
