import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        
        int[] index = new int[26];
        Arrays.fill(index, -1);
        
        for(int i=0;i<s.length();i++){
            char now = s.charAt(i);
            
            answer[i] = index[now-'a'] == -1 ? -1 : i - index[now-'a'];
            index[now-'a'] = i;
        }
        return answer;
    }
}