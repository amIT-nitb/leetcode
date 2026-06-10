/*
 * 26. Remove Duplicates from Sorted Array  (Easy)
 *
 * Approach: classic slow/fast two-pointer dedup on a sorted array.
 *   k is the count of unique elements written so far (and the index of the
 *   next slot to write). Walk i from index 1; whenever nums[i] differs from
 *   the most recently kept value (nums[k-1]), it's a new unique value — write
 *   it at nums[k] and advance.
 *
 *   Why nums[k-1] is the right comparator: the first k elements are already
 *   the deduped prefix, so the last accepted unique value sits at k-1.
 *
 *   nums = [0,0,1,1,1,2,2,3,3,4]
 *           k=1
 *   i=1 (0) == nums[0] -> skip
 *   i=2 (1) != nums[0]=0 -> write nums[1]=1, k=2
 *   i=3 (1) == nums[1]=1 -> skip
 *   ...
 *   final k=5, prefix [0,1,2,3,4]
 *
 * Time: O(n)   Space: O(1)
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int k = 1;                                   // nums[0] is always kept
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[k - 1]) {            // strictly greater since input is sorted
                nums[k++] = nums[i];
            }
        }
        return k;
    }
}
