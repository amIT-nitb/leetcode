/*
 * 2042. Check if Numbers Are Ascending in a Sentence  (Easy)
 *
 * Approach: split on spaces, try to parse each token as int.
 *   Words throw NumberFormatException on parse — caught and ignored. For
 *   numeric tokens, verify each is STRICTLY greater than the previous numeric
 *   token (note: <= prev fails — equal isn't allowed). prev starts at -1 so
 *   the first number always passes.
 *
 *   Try/catch as control flow is the simple version; an isDigit check (see
 *   commented-out alternative) avoids exception overhead but is more verbose.
 *
 * Time: O(n)   Space: O(n) for split tokens
 */
class Solution {
    public boolean areNumbersAscending(String s) {

        int prev = -1;
        int num;
        for(String token: s.split(" ")){
          try{
              num = Integer.parseInt(token);
              // strictly greater: equal numbers must also fail
              if(num <= prev){
                return false;
              }
              else
                  prev = num;
          }   
          catch( Exception e){}
              
        }   
          return true; 
    }
}   
        //     String[] tokens= s.split(" ",0);
        //     int curr = -1;
        //     int num;
        //     for(String index : tokens){
        //         if(isNumber(index)){
        //             num = Integer.parseInt(index);
        //         if(num > curr){
        //             curr = num;
        //         }
        //         else{
        //             return false;
        //         }
        //       }
        //     }
        // return true;

    
//     private boolean isNumber(String index){
//         // check if string is number
//         try{
//             Integer.parseInt(index);
//             return true;
//         }
//         catch(NumberFormatException e){
//             return false;
//         }
//     }
