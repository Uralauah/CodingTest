import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        
        for(int i=0;i<s.length();i++){
            char now = s.charAt(i);
            
            if(now == ' '){
                sb.append(" ");
                idx = 0;
                continue;
            }
            
            if (idx % 2 == 0) {
                sb.append(Character.toUpperCase(now));
            } else {
                sb.append(Character.toLowerCase(now));
            }
            idx++;
        }
        
        
        return sb.toString();
    }
}