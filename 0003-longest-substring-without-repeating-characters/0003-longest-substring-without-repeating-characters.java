import java.lang.Math;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int mc = 0;
        int start =0 ; 
        HashMap<Character, Integer> myMap = new HashMap<>();
        for(int i =0 ; i<s.length();i++){
        //    if(!myMap.containsKey(s.charAt(i))){
        //        //myMap.put(s.charAt(i),i);
        //        c++;  }
        //    else{
        //        mc = Math.max(mc,c);
        //        myMap.clear();     
        //        c=1;
        //    }
        //    myMap.put(s.charAt(i),i);
        if(myMap.containsKey(s.charAt(i))){
             //left to the char beyond that of duplicate found
            // start = Math.max(myMap.get(s.charAt(i))+1,start);
            // start = myMap.get(s.charAt(i)) +1; /// if we do this we might take chars which are not in current sub array.
            start = (myMap.get(s.charAt(i))>=start)? (myMap.get(s.charAt(i))+1):start;
           }
            myMap.put(s.charAt(i),i);
          //  mc = Math.max(mc,i-start+1);
            mc = ((i-start)>=mc)?(i-start+1):mc;
        }
        return mc;
    }
}