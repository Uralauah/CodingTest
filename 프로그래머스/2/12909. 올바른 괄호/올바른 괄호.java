import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        ArrayDeque<Character> stack = new ArrayDeque<>();

        for(int i=0;i<s.length();i++){
            char now = s.charAt(i);
            if(now == '('){
                stack.push(now);
            }
            else{
                if(stack.isEmpty() || stack.peek() != '('){
                    answer = false;
                    break;
                }
                stack.poll();
            }
        }
        
        if(!stack.isEmpty())
            answer = false;
        
        return answer;
    }
}