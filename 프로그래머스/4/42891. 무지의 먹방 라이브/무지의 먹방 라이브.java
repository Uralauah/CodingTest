import java.util.*;

class Solution {
    
    public class Food{
        public int time;
        public int idx;
        
        public Food(int time, int idx){
            this.time = time;
            this.idx = idx;
        }
    }
    
    public int solution(int[] food_times, long k) {
        int answer = 0;
        long len = food_times.length;
        
        PriorityQueue<Food> pq = new PriorityQueue<>((o1, o2)->{
            if(o1.time == o2.time)
                return o1.idx - o2.idx;
            return o1.time - o2.time;
        });
        
        for(int i=0;i<len;i++){
            pq.add(new Food(food_times[i],i));
        }
        
        long t = 0;
        while(!pq.isEmpty()){
            Food now = pq.peek();
            long cur = now.time - t;
            
            // System.out.println(now.idx+" "+now.time+" "+cur+" "+ len + " "+k);
            
            if(cur*len <= k){
                t = now.time;
                k -= cur*len;
                len--;
                pq.poll();
                continue;
            }
            break;
        }
        
        if(pq.size()==0)
            return -1;
        
        Food[] remain = new Food[pq.size()];
        for(int i=0;i<remain.length;i++){
            remain[i] = pq.poll();
        }
        
        // for(int i=0;i<remain.length;i++){
        //     System.out.println(remain[i].time+ " " + remain[i].idx);
        // }
        
        Arrays.sort(remain, new Comparator<Food>(){
            @Override
            public int compare(Food o1, Food o2){
                return o1.idx - o2.idx;
            }
        });
        
        Long r = k%remain.length;
        
        return remain[r.intValue()].idx+1;
        // return 0;
    }
}