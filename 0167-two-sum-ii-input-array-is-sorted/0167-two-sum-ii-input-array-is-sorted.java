class Solution {
 public int[] twoSum(int[] numbers, int target) {
        
        // do binary search and edge conditions check
        // pass the sub array to private method for index finding
                // if(target>numbers[numbers.length-1] || target < numbers[0]){
                //    return null;
                // }
                //  int number = getIndex(numbers,  target);
                //  int [] num = Arrays.copyOfRange(numbers, 0, number+1);
                //  return sum (num, target,number);

            int left = 0;
            int right = numbers.length-1;
            while (left < right){
                int sum = numbers[left] + numbers[right];
 
            if (target < sum){
                 right --;
             }
             else if (target > sum) {
                 left ++;
             }
             else
                return new int[] {left+1,right+1};

            }    
                return null;

            }
        
            // private  int getIndex(int[] numbers, int target){
            //         for (int j =numbers.length-1 ; j>0; j--){
            //              if(target>= numbers[j]){
            //                  return j;
            //              }   
            //         }
            //     return 0;    
            // }
        
            // private  int[] sum(int[] numbers, int target, int offset) {
            //     Map<Integer, Integer> map = new HashMap<>();
            //     for (int i = 0; i< numbers.length; i++){
            //             int comp = target - numbers[i];
            //             if(map.containsKey(comp) && map.get(comp) != i){
            //                return new int [] {i+offset,map.get(comp)+offset};     
            //             }
            //             map.put(numbers[i],i);
            //     }
            //     return null;
            // }
}