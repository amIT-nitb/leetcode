class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
       List<List<Integer>> result = new ArrayList<>();
       List<int[]> heights = new ArrayList<>();
        // convert the inout such that we have tuple of start , height & end ,height
        // make thestat negative to understand the difference
        // we save the heights in Pirority queue sorted manner.
        // when negative height we pop from q and positive height we add in q.
        // maintain previous n current max if they are diff save the  x and currnt max as  result. 
       transform(buildings,heights); 
       Collections.sort(heights,(a,b)-> (a[0] == b[0])? a[1]-b[1] : a[0] - b[0]); 
       // sorted PQ on basis of X coords.
       PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b)->(b-a));
       pq.offer(0); // intial value
       int prevMax =0;
       int currMax = 0;
       
       for (int[] height : heights){
           if(height[1] <0){ //start of building
                pq.offer(-height[1]);
           }
           else{ // end of building
                pq.remove(height[1]);
           }
           currMax = pq.peek();
           if(prevMax != currMax ){
                List<Integer> sub = new ArrayList<>();
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