class Solution {
    public void duplicateZeros(int[] arr) {
        int shift = 0;
        // Count the number of 0s
        for (int i = 0; i < arr.length; i++) {
            shift += arr[i] == 0 ? 1 : 0;
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            // if the current value can be fit
            if (shift + i < arr.length) {
                arr[shift + i] = arr[i];
            }
            // if the current value is 0, shift--
            // and arr[shift + i] should also be 0 (duplicate)
            if (arr[i] == 0 && --shift + i < arr.length) {
                arr[shift + i] = 0;
            }
        }
    }
};