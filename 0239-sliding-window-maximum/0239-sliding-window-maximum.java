class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int i =0;
        Deque<Integer> que = new ArrayDeque<>();
        int size = len -k +1;
        int result[] = new int[size];

        //iterate and add element in dq such that hey arein decresing fashion
        //  if new element is smaller than last insert else pop till the previus condition works.
        // first windows  fill up
        int x =0;
        for (;x<k;x++){
            while(!que.isEmpty() && nums[x] > nums[que.peekLast()]){
                que.removeLast();
            }
            que.add(x);
        } 

        for(x=k;x<len;x++){
            //element at the front  would be max so save it
            result[i++] =  nums[que.getFirst()];
            // remove element outside the current window
            while(!que.isEmpty() && que.peekFirst() == x-k){
                que.removeFirst();
            }
            // remove smaller element from the window in the Q
            while(!que.isEmpty() && nums[x] > nums[que.peekLast()]){
                que.removeLast();
            }
            que.add(x);        
        }
       // result[i] = nums[que.pollFirst()]; //  add max for the last window
          result[i] = nums[que.getFirst()];  
        
        return result;
    }


}