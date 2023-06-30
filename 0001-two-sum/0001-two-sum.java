 
class Solution {
    public int[] twoSum(int[] nums, int target) {
         int[] output = new int[2];
         Map<Integer, Integer> map = new HashMap<>();
         for(int i =0;i<nums.length;i++){

             int comp = target - nums[i];
             if(map.containsKey(comp) && map.get(comp) != i){
                 return new int [] {i,map.get(comp)};
             }
              map.put(nums[i],i);
         }   
        //  for(int j=0;j<nums.length;j++){
        //      int left = target - nums[j];
        //      if(map.containsKey(left) && map.get(left) != j) {
        //          output[0] = j;
        //          output[1] = map.get(left);
        //      }
        //  }   
         return null;
    }
}