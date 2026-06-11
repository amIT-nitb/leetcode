/*
 * 27. Remove Element  (Easy)
 *
 * Approach: two pointers — read i, write k. When nums[i] != val, copy to
 *   nums[k] and bump k; otherwise skip. Final k is the kept count.
 *
 *   nums = [3,2,2,3] val=3
 *   i=0 skip; i=1 write nums[0]=2; i=2 write nums[1]=2; i=3 skip  ->  k=2
 *
 * Time: O(n)   Space: O(1)
 */
class Solution {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        var k = 0
        for (i in nums.indices) {
            if (nums[i] != `val`) {
                nums[k++] = nums[i]
            }
        }
        return k
    }
}
