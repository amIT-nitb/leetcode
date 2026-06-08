/*
 * 239. Sliding Window Maximum  (Hard)
 *
 * Approach: monotonic deque of INDICES (decreasing by value).
 *   Invariant: nums[deque.front()] is always the max of the current window,
 *   and the deque holds indices in left-to-right order with strictly
 *   decreasing values.
 *
 *   On each new index x:
 *     1. Pop from BACK while nums[x] >= nums[back] — those values can never
 *        be the max while x is in the window (and x outlives them on the right).
 *     2. Pop from FRONT if it's now outside [x-k+1 .. x] (i.e. front == x-k).
 *     3. Push x onto the back.
 *     4. Once we've seen k elements, nums[front] is this window's answer.
 *
 *      window slides right -> drop stale from front, drop dominated from back
 *
 *      nums = [1 3 -1 -3 5 3 6 7], k = 3
 *      indices in deque (values shown): [3] -> [3,-1] -> [3,-1,-3] (front emitted: 3)
 *      slide: pop 3 (=x-k), add 5 popping -1,-3 -> [5] -> [5,3] -> ...
 *
 * Time: O(n)  every index pushed and popped at most once
 * Space: O(k) deque size
 */
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int i =0;
        Deque<Integer> que = new ArrayDeque<>();
        int size = len -k +1;
        int result[] = new int[size];

        // first window: fill the deque from indices 0..k-1
        int x =0;
        for (;x<k;x++){
            while(!que.isEmpty() && nums[x] > nums[que.peekLast()]){
                que.removeLast();
            }
            que.add(x);
        } 

        for(x=k;x<len;x++){
            // front of deque is index of max in the window that just ended at x-1
            result[i++] =  nums[que.getFirst()];
            // drop the front if it has now slid out of [x-k+1 .. x]
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