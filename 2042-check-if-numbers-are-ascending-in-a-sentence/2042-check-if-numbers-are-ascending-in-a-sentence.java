class Solution {
    public boolean areNumbersAscending(String s) {
        
        int prev = -1;
        int num;
        for(String token: s.split(" ")){
          try{
              num = Integer.parseInt(token);
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
