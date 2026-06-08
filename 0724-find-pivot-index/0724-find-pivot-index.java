/*
 * 724. Find Pivot Index  (Easy)
 *
 * Approach: two passes, prefix-sum trick.
 *   First pass: compute total = sum(nums).
 *   Second pass: walk i = 0..n-1 carrying leftSum.
 *     rightSum at i = total - leftSum - nums[i].
 *     The pivot condition is leftSum == rightSum
 *       -> leftSum == total - leftSum - nums[i]
 *       -> 2*leftSum + nums[i] == total
 *   Return the first i that satisfies it; -1 otherwise.
 *
 * Time: O(n)   Space: O(1)
 */
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