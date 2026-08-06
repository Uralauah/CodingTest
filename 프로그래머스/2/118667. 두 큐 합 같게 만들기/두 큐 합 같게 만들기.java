import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long sum1 = 0;
        long sum2 = 0;
        
        Deque<Integer> q1 = new ArrayDeque<>();
        Deque<Integer> q2 = new ArrayDeque<>();
        
        for(int num : queue1){
            sum1+=num;
            q1.offerLast(num);
        }
        for(int num : queue2){
            sum2+=num;
            q2.offerLast(num);
        }
        
        if ((sum1 + sum2) % 2 != 0) {
            return -1;
        }
        
        int idx = (queue1.length + queue2.length)*2;
        for(int i=0;i<=idx;i++){
            if(sum1 == sum2){
                return i;
            }
            
            if(sum1 < sum2){
                int num = q2.pollFirst();
                q1.offerLast(num);
                sum1 += num;
                sum2 -= num;
                continue;
            }
            
            if(sum1 > sum2){
                int num = q1.pollFirst();
                q2.offerLast(num);
                sum1 -= num;
                sum2 += num;
            }
        }
        
        return -1;
    }
}