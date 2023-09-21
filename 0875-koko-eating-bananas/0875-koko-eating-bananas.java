class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        //find the max banana pile 
        int pile = Integer.MIN_VALUE;
        int n = piles.length;
        for(int i=0;i<n;i++){
            pile = Math.max(pile, piles[i]);
        }
        // when H is less than N its  not possible to eat when H is same as N then speed  should be max banana pile  else between 1 to max piles. ( will be 1 when number of sum of all bananas is same as number of hours)
        if(h == n) return pile;
        //use binary search to optimize the search for the min speed.
        int low =1;
        int high = pile-1; 
        while(low<=high){ //binary search for the number which allows to eat all in H hours
            int mid = (low+high) /2;
            int hour =0;
            for(int j=0;j<n;j++){
                hour += Math.ceil((double)piles[j]/mid);
            }
            if(hour <=h)// too fast
                high = mid-1;
            else
                low = mid +1;    // too slow
        }
        return low;
    }
}