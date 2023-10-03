class Solution {
    public int pivotIndex(int[] nums) {
        // find the index where left sum  equal right sum.
        int total =0;
        int sum =0;
        for(int i=0;i<nums.length;i++)
            total +=nums[i];
        for(int j=0;j<nums.length;j++){
            if(sum == total - sum - nums[j])
                return j;
            sum += nums[j];
        }    
        return -1;
    }
}