import java.util.*;

class Solution {
    public int toMin(String time){
        int h = Integer.parseInt(time.substring(0,2));
        int m = Integer.parseInt(time.substring(3));
        
        return h*60+m;
    }
    
    public int solution(String[][] book_time) {
        int answer = 1;
        int n = book_time.length;
        int[][] time = new int[n][2];
        
        for(int i=0;i<n;i++){
            time[i][0] = toMin(book_time[i][0]);
            time[i][1] = toMin(book_time[i][1]);
        }
        
        Arrays.sort(time, (o1,o2)->{
            if(o1[0]==o2[0])
                return Integer.compare(o1[1], o2[1]);
            return Integer.compare(o1[0], o2[0]);
        });
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        pq.add(time[0][1]+10);
        
        for(int i=1;i<n;i++){
            if(pq.peek() <= time[i][0]){
                pq.poll();
            }
            
            pq.offer(time[i][1]+10);
            
            answer = Math.max(answer, pq.size());
        }
        
        return answer;
    }
}