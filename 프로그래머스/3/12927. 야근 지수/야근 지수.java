import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int work : works)
            pq.add(work);
        
        while(n > 0 && !pq.isEmpty()){
            int now = pq.poll();
            
            now--;
            n--;
            
            if(now > 0)
                pq.add(now);
        }
        
        while(!pq.isEmpty()){
            answer+= Math.pow(pq.poll(), 2);
        }
        
        return answer;
    }
}