/*
 * 7. Reverse Integer  (Medium)
 *
 * Approach: pop-and-push digits, with overflow check BEFORE the multiplication.
 *   Repeatedly take last digit, append to sum, shrink x. Detect 32-bit overflow
 *   without actually overflowing.
 *
 *   Int.MAX_VALUE = 2147483647   -> MAX_VALUE/10 = 214748364 (last digit 7).
 *   Before doing sum = sum*10 + curr, overflow is guaranteed if:
 *     - sum > MAX_VALUE/10           (already too big)
 *     - sum == MAX_VALUE/10 AND curr > 7   (one more digit tips it)
 *
 * Time: O(log10 |x|)   Space: O(1)
 */
class Solution {
    fun reverse(x: Int): Int {
        var n = x
        val negative = n < 0
        if (negative) n = -n
        var sum = 0
        while (n > 0) {
            val curr = n % 10
            // overflow check BEFORE the multiply; MAX_VALUE/10 = 214748364, last digit 7
            if (sum > Int.MAX_VALUE / 10 || (sum == Int.MAX_VALUE / 10 && curr > 7)) return 0
            sum = sum * 10 + curr
            n /= 10
        }
        return if (negative) -sum else sum
    }
}
