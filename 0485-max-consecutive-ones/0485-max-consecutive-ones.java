/*
 * 485. Max Consecutive Ones  (Easy)
 *
 * Approach: linear scan with a running counter.
 *   Walk the array; on a 1, increment the running streak and update the max;
 *   on a 0, reset the streak to 0. Single pass, no extra structures.
 *
 * Time: O(n)   Space: O(1)
 */
import java.lang.Math;
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int mc =0;
        int c = 0;
        // for(;i<nums.length;i++){
        //     // if(nums[i] == 0){
        //     //     c =0;
        //     //     continue;
        //     // }
        //     // else{
        //     // c++;
        //     // }
        //     // mc = Math.max(mc,c);
        //     if(nums[i] == 1){
        //         mc = Math.max(mc,++c);
        //     }
        //     else{
        //         c= 0;
        //     }
        // }
        for(  final int i : nums){
        if(i == 1){
            mc = Math.max(mc,++c);
        }
        else{
            c= 0;
        }
     }

        return mc;
    }
}