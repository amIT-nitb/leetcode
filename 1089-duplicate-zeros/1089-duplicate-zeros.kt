/*
 * 1089. Duplicate Zeros  (Easy)
 *
 * Approach: in-place, write right-to-left with a shift offset.
 *   shift = #zeros yet-to-duplicate to the right of i. Walking right-to-left
 *   means every read happens before the corresponding write.
 *   Bounds checks are vital — trailing zeros may fall off the right edge.
 *
 *      [1,0,2,3,0,4,5,0]  ->  [1,0,0,2,3,0,0,4]
 *
 * Time: O(n)   Space: O(1)
 */
class Solution {
    fun duplicateZeros(arr: IntArray) {
        var shift = 0
        for (x in arr) if (x == 0) shift++

        for (i in arr.indices.reversed()) {
            if (i + shift < arr.size) arr[i + shift] = arr[i]
            if (arr[i] == 0) {
                shift--
                if (i + shift < arr.size) arr[i + shift] = 0
            }
        }
    }
}
