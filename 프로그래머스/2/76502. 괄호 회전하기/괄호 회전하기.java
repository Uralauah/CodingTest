import java.util.*;

class Solution {
    public boolean isPair(char a, char b){
        return (a=='(' && b==')') ||
            (a=='{' && b=='}') ||
            (a=='[' && b==']');
    }
    
    public boolean isClose(char a){
        return a==')' || a=='}' || a==']';
    }
    
    public int solution(String s) {
        int answer = 0;
        
        for(int i=0;i<s.length();i++){
            String temp = s.substring(i) + s.substring(0,i);
            
            ArrayDeque<Character> stack = new ArrayDeque<>();
            
            for(int j=0;j<temp.length();j++){
                char now = temp.charAt(j);
                
                if(!stack.isEmpty() && isClose(now) && isPair(stack.peek(), now)){
                    stack.poll();
                    continue;
                }
                
                stack.push(now);
            }
            
            if(stack.isEmpty())
                answer++;
        }
        
        return answer;
    }
}