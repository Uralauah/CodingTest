import java.util.*;

class Solution {
    public class Job{
        public int num;
        public int requestTime;
        public int jobTime;
        
        public Job(int num, int requestTime, int jobTime){
            this.num = num;
            this.requestTime = requestTime;
            this.jobTime = jobTime;
        }
    }
    
    public int solution(int[][] jobs) {
        int answer = 0;
        int len = jobs.length;
        PriorityQueue<Job> pq = new PriorityQueue<>((o1, o2)->{
            if(o1.requestTime == o2.requestTime && o1.jobTime == o2.jobTime)
                return o1.num - o2.num;
            else if(o1.jobTime == o2.jobTime)
                return o1.requestTime - o2.requestTime;
            else
                return o1.jobTime - o2.jobTime;
        });
        
        for(int i=0;i<len;i++){
            pq.add(new Job(i, jobs[i][0], jobs[i][1]));
        }
        
        int time = 0;
        while(!pq.isEmpty()){
            Job now = pq.poll();
            //뽑았는데 현재 시간 이후라면 다시 넣어주고 다른거 뽑아야 함
            List<Job> temp = new ArrayList<>();
            while(!pq.isEmpty() && now.requestTime>time){
                temp.add(now);
                now = pq.poll();
            }
            if(pq.isEmpty()){
                now = temp.get(0);
                temp.remove(Integer.valueOf(0));
            }
            pq.addAll(temp);
            // System.out.println(now.num + " adsfas");
            
            
            time = Math.max(time, now.requestTime);
            time += now.jobTime;
            answer+=time-now.requestTime;
            
            // System.out.println(answer);
        }
        return answer/len;
    }
}


/*
우선순위큐 
*/