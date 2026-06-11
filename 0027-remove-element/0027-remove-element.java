/*
 * 27. Remove Element  (Easy)
 *
 * Approach: two pointers, write/read.
 *   Read pointer i scans every position. Write pointer k tracks where the next
 *   "kept" value goes. When nums[i] != val, copy it to nums[k] and advance k;
 *   otherwise just skip. Final k is the count of kept elements.
 *
 *   nums = [3, 2, 2, 3]  val = 3
 *           ^k                          (nothing written yet)
 *   i=0 -> 3 == val, skip
 *   i=1 -> 2 != val, write nums[0]=2, k=1
 *   i=2 -> 2 != val, write nums[1]=2, k=2
 *   i=3 -> 3 == val, skip
 *   result: nums[0..k-1] = [2, 2], k=2
 *
 * Time: O(n)   Space: O(1)
 */
class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k++] = nums[i];
            }
        }
        return k;
    }
}
