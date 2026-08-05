import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int s : scoville){
            pq.add((long)s);
        }
        
        while(!pq.isEmpty()){
            long a = pq.poll();
            if(a >= K)
                break;
            if(pq.isEmpty())
                return -1;
            
            long b = pq.poll();
            
            pq.add(a+b*2);
            
            answer++;
        }
        return answer;
    }
}