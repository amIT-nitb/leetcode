class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double d= 0.0 ;
        int n = nums1.length;
        int m = nums2.length;
        int [] temp = new int[n+m];
        int p1 =0,p2=0;
        int c =0, median =0;
        int threshold = ((n+m)/2) ;
        while(c <= threshold){
        // check elements and add the smaller element in the  final array 
        // increment the src and final array counter
        //stop once median element in the final array and return that element.
        if(p1<n && p2<m){
            if(nums1[p1]<nums2[p2]){
                temp[c] = nums1[p1];
                p1++;
            }
            else{
                temp[c] =nums2[p2];
                p2++;
            }
        }
        else if(p1<n){
            temp[c] = nums1[p1];
            p1++;
        }
        else{
            temp[c] =nums2[p2];
            p2++;
        }
        c++;
    }

// System.out.println("n:"+n);
// System.out.println("m:"+m);
//System.out.println("median:"+median);
// System.out.println("\n temp:"+Arrays.toString(temp));
        // return 
        
        int m1 = temp[(m+n)/2];
        if((n+m) %2 ==0){
            
           // d =  (double)(temp[(m+n)/2] +  temp[((m+n)/2) -1])/2;
           median = (((m+n)/2)-1);
           int m2 = temp[median];
        //    System.out.println("\n m1:"+m1);
        //    System.out.println("\n m2:"+m2);
           d = (double)(m1+m2)/2;
        }
        else{
            d = (double) m1;   
        }
        
        return d;
    }
}