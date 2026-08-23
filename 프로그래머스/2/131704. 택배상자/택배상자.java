import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        
        Deque<Integer> stack = new ArrayDeque<>();
        int max = order.length;
        int next = 1;
        
        for(int i=0;i<order.length;i++){
            int now = order[i];
            while(next < now){
                stack.offerLast(next++);
            }
            
            if(next == now){
                answer++;
                next++;
                continue;
            }
            
            if (stack.isEmpty() || stack.peekLast() != now) {
                break;
            }
            
            stack.pollLast();
            answer++;
        }
        return answer;
    }
}