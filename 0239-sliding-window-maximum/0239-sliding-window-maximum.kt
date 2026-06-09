import java.util.ArrayDeque

/*
 * 239. Sliding Window Maximum  (Hard)
 *
 * Approach: monotonic deque of INDICES (values strictly decreasing).
 *   Invariant: nums[deque.first()] is always the current window's max.
 *
 *   For each index x:
 *     1. Pop from back while nums[x] >= nums[back]  (back can never be max again).
 *     2. Pop from front if it's slid out of the window (front == x-k).
 *     3. Push x.
 *     4. Once x >= k-1, emit nums[deque.first()].
 *
 *   Each index enters and leaves the deque at most once -> O(n).
 *
 * Time: O(n)   Space: O(k)
 */
class Solution {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        val n = nums.size
        val result = IntArray(n - k + 1)
        val dq = ArrayDeque<Int>()   // indices, values strictly decreasing
        for (x in 0 until n) {
            // drop back-of-deque values that are dominated by nums[x]
            while (dq.isNotEmpty() && nums[x] >= nums[dq.peekLast()]) dq.pollLast()
            // drop front if it slid out of [x-k+1 .. x]
            if (dq.isNotEmpty() && dq.peekFirst() == x - k) dq.pollFirst()
            dq.offerLast(x)
            if (x >= k - 1) result[x - k + 1] = nums[dq.peekFirst()]
        }
        return result
    }
}
