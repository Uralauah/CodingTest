import java.util.*;

class Solution
{
    public int solution(String s)
    {

        ArrayDeque<Character> stack = new ArrayDeque<>();
        
        for(int i=0;i<s.length();i++){
            char now = s.charAt(i);
            
            if(!stack.isEmpty() && stack.peek() == now){
                stack.pop();
                continue;
            }
            
            stack.push(now);
        }

        return stack.isEmpty() ? 1 : 0;
    }
}