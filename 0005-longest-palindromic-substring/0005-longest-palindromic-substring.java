class Solution {
    public String longestPalindrome(String s) {
        //as we need to find the largest we start the large substring first.
        for(int i =s.length(); i >0;i-- ){
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