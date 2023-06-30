class Solution {
    public int largestAltitude(int[] gain) {
       // int start = 0;
        int m = gain[0] >0 ? gain[0] :0;
        for ( int i =1;i<gain.length;i++){
            // if(i==0){
            //     gain [i] = gain[i] +m;
            // }
            // else{
            //     gain[i] = gain [i-1] + gain[i];
            // }
            gain[i] = gain [i-1] + gain[i];
            m = Math.max(m,gain[i]);
        }
        return m;
    }
}