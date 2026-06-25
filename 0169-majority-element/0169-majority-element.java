/*
 * 169. Majority Element  (Easy)
 *
 * Approach: Boyer-Moore voting.
 *   Walk once, maintaining a "candidate" and a counter. When count hits 0,
 *   adopt the current element as the new candidate. Otherwise +1 if it
 *   matches the candidate, -1 if not. Because the majority element appears
 *   more than n/2 times, every non-majority element it cancels still leaves
 *   at least one of its own votes standing — so whatever survives is it.
 *
 *   This satisfies the follow-up: O(n) time, O(1) space (no hash map / sort).
 *
 * Time: O(n)   Space: O(1)
 */
class Solution {
    public int majorityElement(int[] nums) {
        int candidate = 0, count = 0;
        for (int x : nums) {
            // when count drains to 0, previous candidate is "outvoted" — pick a new one
            if (count == 0) candidate = x;
            count += (x == candidate) ? 1 : -1;
        }
        return candidate;
    }
}
