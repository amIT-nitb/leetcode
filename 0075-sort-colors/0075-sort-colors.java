/*
 * 75. Sort Colors  (Medium)
 *
 * Approach: Dutch National Flag — three pointers, one pass, in place.
 *   Maintain three regions:
 *     [0 .. low-1]   = all 0s   (frozen, won't be touched again)
 *     [low .. mid-1] = all 1s
 *     [mid .. high]  = unknown  (still being scanned)
 *     [high+1 .. n-1]= all 2s   (frozen)
 *
 *      0 0 0 | 1 1 1 | ? ? ? ? | 2 2
 *            ^ low   ^ mid    ^ high
 *
 *   At each step inspect nums[mid]:
 *     0 -> swap with low, advance both (the swapped-in is 1, safe to skip).
 *     1 -> already in place, advance mid only.
 *     2 -> swap with high, shrink high. DO NOT advance mid — the swapped-in
 *          value is still unknown and must be re-inspected next iteration.
 *
 *   That asymmetry (advance mid on 0 but not on 2) is the part that's easy to
 *   get wrong. The reason: when we swap from low, low currently holds a 1 that
 *   we've already classified, so we know what we just received. When we swap
 *   from high, high holds an unclassified value.
 *
 * Time: O(n)   Space: O(1)
 */
class Solution {

   public void  swap (int[] nums, int i, int j){
       int temp = nums[i];
       nums[i] = nums[j];
       nums[j] = temp;
   }

    public void sortColors(int[] nums) {
     int low = 0,mid =0;
     int high = nums.length -1;
     while (mid<= high){
            switch(nums[mid]){
                case 0 :
                    swap(nums, low, mid);
                    low++;
                    mid++;
                    break;
                case 1 :
                    mid++;
                    break;
                case 2 :
                    swap(nums, mid, high);
                    // do NOT advance mid: swapped-in value is still unclassified
                    high--;
                    break;
            }
     }







 // --------brute force apporach to count theindexes and then update the array with the same //       
    //     int zero =0,one =0, two=0;
    //     // find the occurance of each color
    //     for (int i =0 ; i<nums.length;i++){
    //         switch(nums[i]){
    //             case 0: 
    //                 zero++;
    //                 break;
    //             case 1:
    //                 one++;
    //                 break;
    //             case 2:
    //                 two++;
    //                 break;    
    //         }
    //     }
    //     System.out.println("zero:"+zero);
    //     System.out.println("one:"+one);
    //     System.out.println("two:"+two);
    //     // set the array to have exact number of colors count in sorted order
    //     int j =0;

    //         while(j<nums.length && zero >0 ){
    //             nums[j] = 0;
    //             j++;
    //             zero--;
    //         }
    //         while ( j<nums.length && one >0 ){
    //             nums[j] = 1;
    //             j++;
    //             one--;
    //         }
    //         while(j<nums.length  && two > 0){
    //             nums[j] = 2;
    //             j++;
    //             two--;
    //         }

    // }
}
}