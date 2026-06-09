/*
 * 3. Longest Substring Without Repeating Characters  (Medium)
 *
 * Approach: sliding window with a "last seen index" map.
 *   Maintain [start..i] as the current candidate window. Each char's most recent
 *   index lives in the map. When we hit a duplicate that lies INSIDE the current
 *   window (last-seen index >= start), jump start past it. Otherwise the
 *   duplicate is stale (already left the window) and we ignore it.
 *
 *   The clamp `start = max(prevSeen+1, start)` is critical:
 *     "tmmzuxt" — when we see the second 't', prevSeen('t') = 0,
 *     but start has already moved to 2 due to the 'm'. We must keep start at 2,
 *     not rewind to 1.
 *
 *      s: t m m z u x t
 *      i: 0 1 2 3 4 5 6
 *           ^ start jumps here when 2nd 'm' hits (prevSeen=1, +1 = 2)
 *                       ^ at 2nd 't': prevSeen('t')=0+1=1, but start=2 wins
 *
 * Time: O(n)   Space: O(min(n, alphabet))
 */
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