import java.util.*;

class Solution {
    public int toMin(String time){
        int h = Integer.parseInt(time.substring(0,2));
        int m = Integer.parseInt(time.substring(3));
        
        return h*60+m;
    }
    
    public String convert(String code) {
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < code.length(); i++) {
            char now = code.charAt(i);
            
            if (i + 1 < code.length() && code.charAt(i + 1) == '#') {
                result.append(Character.toLowerCase(now));
                i++;
            } else {
                result.append(now);
            }
        }
        
        return result.toString();
    }
    
    public String solution(String m, String[] musicinfos) {
        int max = -1;
        String answer = "(None)";
        m = convert(m);
        
        for(int i=0;i<musicinfos.length;i++){
            StringTokenizer st = new StringTokenizer(musicinfos[i], ",");
            
            int start = toMin(st.nextToken());
            int end = toMin(st.nextToken());
            String name = st.nextToken();
            String c = convert(st.nextToken());
            
            int time = end - start;
            StringBuilder code = new StringBuilder();
            
            for(int j=0;j<time;j++){
                code.append(c.charAt(j%c.length()));
            }
            
            if(code.indexOf(m) != -1 && time > max){
                max = time;
                answer = name;
            }
            
        }
        return answer;
    }
}