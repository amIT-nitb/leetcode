/*
 * 167. Two Sum II - Input Array Is Sorted  (Medium)
 *
 * Approach: opposing two pointers, leveraging the sorted invariant.
 *   l = 0, r = n-1. Compute sum = numbers[l] + numbers[r]:
 *     - sum > target -> right value is too big, r--
 *     - sum < target -> left value is too small, l++
 *     - sum == target -> done.
 *   Why this is monotonic and can't miss the answer: any pair (i, j) we skip
 *   was already strictly worse than what we've already proven is achievable.
 *
 *   Result is 1-indexed per the problem statement (return left+1, right+1).
 *   The unsorted hash-map alternative (commented below) is O(n) too but uses
 *   O(n) space; this approach is O(1) space because the array is already sorted.
 *
 * Time: O(n)   Space: O(1)
 */
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