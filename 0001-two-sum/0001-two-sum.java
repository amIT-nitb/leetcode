/*
 * 1. Two Sum  (Easy)
 *
 * Approach: single-pass hash map.
 *   For each element, ask "have I already seen its complement (target - x)?"
 *   If yes -> we have the pair. If no -> remember the current element so a
 *   future iteration can find it. One pass; the map IS the memory.
 *
 *   The naive O(n^2) check (commented out below) needs two passes over the
 *   built map; checking inline as we build avoids that and avoids the
 *   self-pair pitfall (e.g. nums = [3], target = 6 must NOT match itself).
 *
 * Time: O(n)   Space: O(n)
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
         int[] output = new int[2];
         Map<Integer, Integer> map = new HashMap<>();
         for(int i =0;i<nums.length;i++){

             int comp = target - nums[i];
             // check BEFORE inserting: prevents matching nums[i] against itself
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