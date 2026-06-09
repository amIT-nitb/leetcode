/*
 * 410. Split Array Largest Sum  (Hard)
 *
 * Approach: binary search on the ANSWER (not on indices).
 *   The answer (the largest subarray sum) is bounded:
 *     lo = max(nums)   — any single element forces the answer to be at least this
 *     hi = sum(nums)   — using m=1 (one big subarray) gives this upper bound
 *   For a candidate cap `mid`, ask: "can we partition nums into <= m subarrays
 *   such that no subarray sums above `mid`?" via greedy left-to-right pass.
 *   If yes, try smaller (hi = mid - 1, remember mid as a feasible answer).
 *   If no, we need bigger (lo = mid + 1).
 *
 *      cap=mid feasible -> shrink the range to the LEFT (smaller cap)
 *               infeasible -> grow the range to the RIGHT (larger cap)
 *
 *   The greedy isPossible check is correct because if a sum ever exceeds mid,
 *   the only way to fix it is to start a new subarray at that index — there's
 *   no benefit to splitting earlier.
 *
 *   Watch the mid formula: lo + (hi - lo)/2, NOT (lo + hi)/2. Sums can be
 *   large (up to ~1e9 * 1000), and (lo + hi) can overflow int.
 *
 * Time: O(n * log(sum - max))   Space: O(1)
 */
class Solution {
    public int splitArray(int[] nums, int m) {
            
        if (nums == null || nums.length == 0 || m == 0 ) {
            return 0;
        }
        
        int max = 0;
        int sum = 0;
		
		// the lower boundary will be max and upper bounder will be sum for the binary search
        for ( int num : nums ) {
            sum = sum + num;
            max = Math.max(num, max);
        }
        
		// base checks where we do not need to apply binary search
        if ( m == nums.length ) {
            return max;
        } else if ( m == 1 ) {
            return sum;
        } else {
            
            int ans = 0;
            int lo = max;
            int hi = sum;
            
            while ( lo <= hi ) {
			    //remember that we are not using the array index here, do not use (lo+hi)/2
                int mid = lo + ( hi-lo )/2;
				//check if it is possible to form m subarrays with the given mid
                if( isPossible(nums, mid, m) ) {   
				    //if yes, store the answer and reduce the upper boundary
                    ans = mid;
                    hi = mid - 1; 
                } else {
				    //if no, increase the lower boundary to get a higher mid
                    lo = mid + 1;
                }
            }
            
            return ans;
            
        }
    }
    
    public static boolean isPossible ( int[] nums, int mid, int m ) {
        int sum = 0;
        int requiredSubarrays = 1;
        
        for ( int i=0; i < nums.length; i++ ) {
            sum = sum+nums[i];
            if ( sum > mid ) {
                requiredSubarrays++;
                sum = nums[i];
            }
        }
        
        if ( requiredSubarrays <= m ) {
            return true;
        }
        
        return false;
    }    
    
}