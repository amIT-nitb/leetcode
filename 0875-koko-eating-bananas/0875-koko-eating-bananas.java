/*
 * 875. Koko Eating Bananas  (Medium)
 *
 * Approach: binary search on the eating speed `k` (the answer space).
 *   At speed k, hours needed for one pile p is ceil(p / k). Total hours is
 *   sum(ceil(p_i / k)). The hours-needed function is monotonically non-increasing
 *   in k (faster -> not slower), so we can binary-search the smallest k such
 *   that totalHours(k) <= h.
 *
 *   Bounds:
 *     low  = 1            (slowest possible speed)
 *     high = max(piles)   (no benefit to k beyond max pile — already 1 hr/pile)
 *   Special case: if h == n, every pile must be finished in exactly one hour
 *   each, so the answer is max(piles); skip the search.
 *
 *      speed:    1 ... low ... mid ... high ... max
 *      feasible:           ...         X         X      <- binary search the boundary
 *
 *   Floating-point ceil here is fine but the tighter idiom is integer
 *   ((p + k - 1) / k) — same answer, no double conversion. Kept the original
 *   for fidelity to the committed solution.
 *
 * Time: O(n * log(max(piles)))   Space: O(1)
 */
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        //find the max banana pile
        int pile = Integer.MIN_VALUE;
        int n = piles.length;
        for(int i=0;i<n;i++){
            pile = Math.max(pile, piles[i]);
        }
        // h == n: must finish every pile in 1 hour, so speed = max pile
        if(h == n) return pile;
        //use binary search to optimize the search for the min speed.
        int low =1;
        int high = pile-1;
        while(low<=high){ //binary search for the smallest speed that fits within h hours
            int mid = (low+high) /2;
            int hour =0;
            for(int j=0;j<n;j++){
                hour += Math.ceil((double)piles[j]/mid);
            }
            if(hour <=h)// fits -> try smaller speed
                high = mid-1;
            else
                low = mid +1;    // too slow -> need faster
        }
        return low;
    }
}