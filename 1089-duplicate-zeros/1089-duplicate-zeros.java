/*
 * 1089. Duplicate Zeros  (Easy)
 *
 * Approach: in-place, write from RIGHT to LEFT using a "shift" offset.
 *   The trick: in the final array, position (i + shift) holds what was at
 *   position i, where `shift` is the number of zeros at indices >= i (i.e.
 *   the zeros yet-to-be-duplicated to the right of i). Walking right-to-left
 *   means we only ever read values we've not yet overwritten.
 *
 *   First pass: count total zeros -> initial `shift`.
 *   Second pass (right to left):
 *     - if i + shift is in bounds, write arr[i] to arr[i + shift].
 *     - if arr[i] is a zero, decrement shift; if the new (i + shift) is in
 *       bounds, also write 0 there (the duplicate).
 *
 *   The bounds checks are vital because the LAST zero(s) may fall off the
 *   right edge; their duplicate (or the zero itself) shouldn't be written.
 *
 *      example  [1,0,2,3,0,4,5,0]  has 3 zeros; shift starts at 3
 *      result   [1,0,0,2,3,0,0,4]  — trailing 0,5,0 fall off
 *
 * Time: O(n)   Space: O(1)
 */
class Solution {
    public void duplicateZeros(int[] arr) {
        int shift = 0;
        // pass 1: shift = number of zeros (each zero will need an extra slot)
        for (int i = 0; i < arr.length; i++) {
            shift += arr[i] == 0 ? 1 : 0;
        }

        // pass 2: walk right-to-left so we never overwrite a value we still need
        for (int i = arr.length - 1; i >= 0; i--) {
            // if the current value's destination is in bounds, copy it
            if (shift + i < arr.length) {
                arr[shift + i] = arr[i];
            }
            // each zero burns one shift slot; write its duplicate if in bounds
            if (arr[i] == 0 && --shift + i < arr.length) {
                arr[shift + i] = 0;
            }
        }
    }
}