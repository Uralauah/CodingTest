import java.util.*;
class Solution {
    public class Tangerine{
        public int size;
        public int cnt;
        
        public Tangerine(int size, int cnt){
            this.size = size;
            this.cnt = cnt;
        }
    }
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i=0;i<tangerine.length;i++){
            map.put(tangerine[i],map.getOrDefault(tangerine[i],0)+1);
        }
        PriorityQueue<Tangerine> pq = new PriorityQueue<>((o1, o2)->{
            return o2.cnt - o1.cnt;
        });
        for(int s : map.keySet()){
            pq.add(new Tangerine(s,map.get(s)));
        }
        
        while(!pq.isEmpty()){
            Tangerine now = pq.poll();
            k-=now.cnt;
            answer++;
            // System.out.println(now.size+" "+now.cnt+" "+k);
            if(k<=0){
                break;
            }
        }
        
        return answer;
    }
}