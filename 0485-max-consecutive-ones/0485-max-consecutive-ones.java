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