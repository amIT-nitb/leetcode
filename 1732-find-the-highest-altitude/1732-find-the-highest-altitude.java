/*
 * 1732. Find the Highest Altitude  (Easy)
 *
 * Approach: prefix-sum tracking max-so-far in place.
 *   altitude[i+1] = altitude[i] + gain[i]; starting altitude is 0. We mutate
 *   the gain array into a running prefix sum and track the running max.
 *   The starting altitude 0 is the floor — if every leg is downhill the
 *   answer is 0, never negative.
 *
 * Time: O(n)   Space: O(1) (mutates input)
 */
class Solution {
    public int largestAltitude(int[] gain) {
       // int start = 0;
        // floor at 0 (start altitude); first reachable point is gain[0]
        int m = gain[0] >0 ? gain[0] :0;
        for ( int i =1;i<gain.length;i++){
            // if(i==0){
            //     gain [i] = gain[i] +m;
            // }
            // else{
            //     gain[i] = gain [i-1] + gain[i];
            // }
            gain[i] = gain [i-1] + gain[i];
            m = Math.max(m,gain[i]);
        }
        return m;
    }
}