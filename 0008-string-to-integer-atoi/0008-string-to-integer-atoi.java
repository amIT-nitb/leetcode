class Solution {
    public int myAtoi(String s) {
        int len = s.length();
        int index = 0;
        long result =0;
        boolean start = false;
        boolean negative = false; 
     // calculate the leading white and sign before running the main loop as this is faster than checking  multiple if else in one while loop.   
    while (index < len && s.charAt(index) == ' '){
    index++;
    }
    if( index <len){
              if( s.charAt(index) == '+') {
                index++;
             }
            else  if( s.charAt(index) == '-'){ 
                    negative= true;
                    index++;
             }
    }
        while ( index < len){
            char cur = s.charAt(index);
            int asc =  cur - '0';
             if(asc>= 0 && asc<= 9){                        
// Integer.MAX_VALUE = 2147483647(10 digits) and //// Integer.MAX_VALUE / 10 = 214748364(9 digits) hence a number bigger than 9 digits would always over flow  even if next digit is 0 and if its same then if the digit is 7 or above.
                if((result>(Integer.MAX_VALUE /10)) || ( result == (Integer.MAX_VALUE/10)  && asc > 7)){
                    return negative?Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                else
                    result = (result *10) + asc;   
            }
            else// break if a invalid char is found
             {  break;}
             index++;   
        }





//         while ( index < len){
//             char cur = s.charAt(index);
            
//             // check and ignore white space
//              if(cur == ' '){
//                  if(start) 
//                      break;
//              }   
//              else if( cur == '+') {
//                  if(start)
//                     break;
//                     else
//                     start =true;
//              }
//              // save symbol + -
//             else  if( cur == '-'){ 
//                  if( !start){
//                      negative= true;
//                      start =true;
//                  }
//                  else{break;}
//              }// save the number
//             else if(asc>= 0 && asc<= 9){                 
//                 start =true;
//                 // if((( result * 10) + asc) > Integer.MAX_VALUE ){
//                 //         result = Integer.MAX_VALUE;
//                 // }
                
// // Integer.MAX_VALUE = 2147483647(10 digits) and //// Integer.MAX_VALUE / 10 = 214748364(9 digits) hence a number bigger than 9 digits would always over flow  even if next digit is 0 and if its same then if the digit is 7 or above.

//                 if((result>(Integer.MAX_VALUE /10)) || ( result == (Integer.MAX_VALUE/10)  && asc > 7)){
//                     return negative?Integer.MIN_VALUE : Integer.MAX_VALUE;
//                 }
//                 else
//                     result = (result *10) + asc;   
//                // System.out.println("result:"+result);
//                // System.out.println("asc:"+asc);   
//             }
//             else// break if a invalid char is found
//              {  break;}
//              index++;   
//         }
   
// check if the int is range bound if not clip else return     
         if(negative){
         result = result*-1;
         }
        //  if (result <= Integer.MIN_VALUE)
        //       return Integer.MIN_VALUE;
        //  }
        //  else{
        //    if(result >= Integer.MAX_VALUE )
        //       return Integer.MAX_VALUE;
        //  }
         return (int)result;
    }
}