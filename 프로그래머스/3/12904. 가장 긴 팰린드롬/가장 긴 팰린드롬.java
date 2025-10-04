import java.util.*;

class Solution
{
    public int solution(String s)
    {
        if(s.length()<=1){
            return s.length();
        }
        int answer = 0;
        int len = s.length();
        StringBuilder sb = new StringBuilder(len*2+3);
        
        sb.append("*");
        for(int i=0;i<len;i++){
            sb.append("#").append(s.charAt(i));
        }
        sb.append("#").append("@");
        
        char[] T = sb.toString().toCharArray();
        int tLen = T.length;
        
        int[] P = new int[tLen];
        int center = 0;
        int right = 0;
        
        for(int i=1;i<tLen-1;i++){
            int mirror = 2*center-i;
            
            if(i<right)
                P[i] = Math.min(right-i, P[mirror]);
            else
                P[i] = 0;
            
            while(T[i-1-P[i]] == T[i+1+P[i]])
                P[i]++;
            
            if(i+P[i]>right){
                center = i;
                right = i+P[i];
            }
            
            answer = Math.max(answer, P[i]);
        }

        return answer;
    }
}
