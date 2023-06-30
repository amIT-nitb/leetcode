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