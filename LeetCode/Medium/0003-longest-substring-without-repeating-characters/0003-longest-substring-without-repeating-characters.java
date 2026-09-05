import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        Set<Character> set = new HashSet<>();

        if(s.length() < 2)
            return s.length();

        int b = 0;
        int e = 1;

        set.add(s.charAt(0));

        while(b<e){
            while(set.contains(s.charAt(e))){
                set.remove(s.charAt(b++));
            }

            set.add(s.charAt(e));
            if(ans < set.size()){
                ans = set.size();
            }
            if(e<s.length()-1)
                e++;
        }
        return ans;
    }
}