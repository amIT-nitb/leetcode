/*
 * 7. Reverse Integer  (Medium)
 *
 * Approach: pop-and-push digits, with overflow check BEFORE the multiplication.
 *   Repeatedly take last digit (x % 10), append to sum (sum * 10 + digit),
 *   shrink x (x / 10). The hard part is detecting 32-bit overflow without
 *   actually overflowing.
 *
 *   Integer.MAX_VALUE = 2147483647   -> MAX_VALUE/10 = 214748364 (its last digit is 7).
 *   Before doing sum = sum*10 + curr, we know it WILL overflow if either:
 *     - sum > MAX_VALUE/10                 (already too big)
 *     - sum == MAX_VALUE/10 AND curr > 7   (one more digit will tip it)
 *   Negative case is symmetric here because we flipped sign first; -2147483648
 *   reverses to overflow, which the same check catches.
 *
 * Time: O(log10 |x|)   Space: O(1)
 */
class Solution {
    public int reverse(int x) {
        boolean negative = false;
        if(x<0){
            negative = true;
            x = x * -1;
        }
        int curr;
        int sum = 0;
        while (x>0) {
             curr = x %10;
            // overflow check BEFORE the multiply; MAX_VALUE/10 = 214748364, last digit 7
            if((sum > Integer.MAX_VALUE /10) ||( sum == Integer.MAX_VALUE/10 && curr > 7 )){
              return 0;
            }
            else{
             sum = (sum *10) + curr;
             x = x/10;
            }
            
        }
        return negative? (sum * -1) : sum;
    }
}