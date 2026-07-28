import java.util.*;

class Solution {
    public String[] solution(String[] expressions) {
        
        List<String> ans = new ArrayList<>();
        List<String> reason = new ArrayList<>();
        int max = 0;
        
        for(int i=0;i<expressions.length;i++){
            if(expressions[i].endsWith("X"))
                ans.add(expressions[i]);
            else
                reason.add(expressions[i]);
            
            for(int j=0;j<expressions[i].length();j++){
                char now = expressions[i].charAt(j);
                
                if(now >= '0' && now<'9')
                    max = Math.max(max, now - '0');
            }
        }
        String[] answer = new String[ans.size()];
        
        boolean[] isPossible = new boolean[10];
        Arrays.fill(isPossible, true);
        
        for(int i=0;i<Math.max(2, max+1);i++){
            isPossible[i] = false;
        }
        
        for(String now : reason){
            StringTokenizer st = new StringTokenizer(now);
            String num1 = st.nextToken();
            String op = st.nextToken();
            String num2 = st.nextToken();
            st.nextToken();
            String result = st.nextToken();
            
            for(int i=2;i<=9;i++){
                if(!isPossible[i])
                    continue;
                
                int a = Integer.parseInt(num1, i);
                int b = Integer.parseInt(num2, i);
                int r = Integer.parseInt(result, i);
                
                if("+".equals(op) && a+b != r){
                    isPossible[i] = false;
                }
                else if("-".equals(op) && a-b != r){
                    isPossible[i] = false;
                }
            }
        }
        
        int idx = 0;
        for(String now : ans){
            StringTokenizer st = new StringTokenizer(now);
            String num1 = st.nextToken();
            String op = st.nextToken();
            String num2 = st.nextToken();
            
            Set<String> s = new HashSet<>();
            for(int i=2;i<=9;i++){
                if(!isPossible[i])
                    continue;
                
                int a = Integer.parseInt(num1, i);
                int b = Integer.parseInt(num2, i);
                
                if("-".equals(op))
                    s.add(Integer.toString(a-b, i));
                else
                    s.add(Integer.toString(a+b, i));
            }
            
            now = now.substring(0,now.length()-1);
            if(s.size()==1){
                answer[idx++] = now+s.iterator().next();
            }
            else{
                answer[idx++] = now+"?";
            }
        }
        
        return answer;
    }
}