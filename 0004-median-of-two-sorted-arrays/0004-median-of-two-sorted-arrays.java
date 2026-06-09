/*
 * 4. Median of Two Sorted Arrays  (Hard)
 *
 * Approach used here: merge-up-to-the-median (NOT the optimal O(log) binary search).
 *   Walk both arrays with two pointers, picking the smaller front element each step,
 *   into a temp array. Stop after copying enough elements to know the median index.
 *   For odd total n+m, median is temp[(n+m)/2]. For even total, average of the
 *   two middle elements: temp[(n+m)/2] and temp[(n+m)/2 - 1].
 *
 *   This is O(n+m) time / O(n+m) space — accepts on the LeetCode judge but the
 *   problem's intended solution is the partition-based binary search at O(log min(n,m)).
 *
 *   threshold layout (n+m=7, threshold=3): we only need to fill temp[0..3]
 *      [_, _, _, _, ., ., .]    fill until c > threshold; rest is irrelevant
 *
 * Time: O(n+m)   Space: O(n+m)
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double d= 0.0 ;
        int n = nums1.length;
        int m = nums2.length;
        int [] temp = new int[n+m];
        int p1 =0,p2=0;
        int c =0, median =0;
        int threshold = ((n+m)/2) ;
        // only merge as far as the median position; rest of temp stays unused
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