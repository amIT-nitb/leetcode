/*
 * 218. The Skyline Problem  (Hard)
 *
 * Approach: line-sweep over building edges with a max-heap of active heights.
 *   Encode each building as TWO events at x = left (start) and x = right (end).
 *   Use a sign trick on the height to distinguish start vs end events:
 *     start -> store -h (negative)
 *     end   -> store +h (positive)
 *   Then sort events by (x, height). The signed-height tiebreak gives us the
 *   ordering we need at duplicate x's:
 *     - At the SAME x, starts (negative h) sort BEFORE ends (positive h).
 *       Critical when two buildings touch: a new building starting at x must
 *       be active before we drop the one ending at x, otherwise we'd emit a
 *       phantom dip down to 0.
 *     - Two starts at same x: taller first (more negative h sorts first) —
 *       prevents two key-points at same x.
 *     - Two ends at same x: shorter first — prevents intermediate emission.
 *
 *   Maintain a max-heap of CURRENTLY ACTIVE heights (seeded with 0 for ground).
 *   On a start event, push h; on an end event, remove h. After each event,
 *   compare currentMax = pq.peek() to prevMax — if changed, emit (x, currentMax).
 *
 *      buildings (skyline outline = key points where height changes):
 *               ____
 *           ___|    |___
 *          |    ____|   |
 *      ____|   |        |__
 *
 *   Note: pq.remove(h) on Java PQ is O(n). For 218 a TreeMap<height,count>
 *   gives O(log n) and the same answer; this version is judge-accepted.
 *
 * Time: O(n^2) worst (PQ.remove)   Space: O(n)
 */
class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
       List<List<Integer>> result = new ArrayList<>();
       List<int[]> heights = new ArrayList<>();
       transform(buildings,heights);
       // sort by x, then by signed height: starts (negative) before ends (positive)
       Collections.sort(heights,(a,b)-> (a[0] == b[0])? a[1]-b[1] : a[0] - b[0]);
       // max-heap of active heights; seed with 0 = ground level
       PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b)->(b-a));
       pq.offer(0);
       int prevMax =0;
       int currMax = 0;

       for (int[] height : heights){
           if(height[1] <0){ //start of building (h was stored negative)
                pq.offer(-height[1]);
           }
           else{ // end of building
                pq.remove(height[1]);
           }
           currMax = pq.peek();
           if(prevMax != currMax ){
                List<Integer> sub = new ArrayList<>(2);
                sub.add(height[0]);
                sub.add(currMax);
                result.add(sub);
                prevMax = currMax;
           }
       }

       return result;
    }

    private void transform(int[][] buildings,List<int[]> heights ){
            for(int[]build : buildings){
                heights.add(new int[]{build[0], -build[2]});
                heights.add(new int[]{build[1], build[2]});
            }

    }
}