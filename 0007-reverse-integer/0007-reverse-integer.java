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