/*
 * 5. Longest Palindromic Substring  (Medium)
 *
 * Approach used here: shrink-from-largest brute force (O(n^3) worst case).
 *   Try substring lengths from n down to 1. For each length, try every starting
 *   index. Return as soon as one is a palindrome — by construction it's the
 *   longest. Early termination saves work when the answer is long; degenerates
 *   when it isn't (e.g. single-char answer scans everything).
 *
 *   The optimal approaches are O(n^2) "expand around center" or O(n) Manacher's;
 *   this one accepts on LeetCode for moderate input but isn't asymptotically optimal.
 *
 *      length:  n      n-1    n-2 ...
 *      try:   [0..n]  [0..n-1][1..n] ...
 *               ^ first palindrome wins; return immediately
 *
 * Time: O(n^3) worst   Space: O(1) (excluding the substring())
 */
class Solution {
    public String longestPalindrome(String s) {
        //as we need to find the largest we start the large substring first.
        for(int i =s.length(); i >0;i-- ){
            // first palindrome found at this length is THE answer; early return
            for ( int j=0; j<=s.length()-i; j++){
                if(check(j,i+j,s)){
                    return s.substring(j,i+j);
                }
            }
        }
         return "";
    }

// helper to check if the sub stringwith index i & j in string S is palindrome
    public boolean check(int i , int j , String s){
        j --;
      while (i<j){
          if(s.charAt(i) != s.charAt(j))
                return false;
          i++;
          j--;  
      }
      return true;

    }
}