import java.util.*;

class Solution {
    public class Task{
        String name;
        int start;
        int remain;
        
        public Task(String name, int start, int remain){
            this.name = name;
            this.start = start;
            this.remain = remain;
        }
    }
    
    public String[] solution(String[][] plans) {        
        Deque<Task> paused = new ArrayDeque<>();
        PriorityQueue<Task> waiting = new PriorityQueue<>((o1, o2) -> {
            return o1.start - o2.start;
        });
        
        for(int i=0;i<plans.length;i++){
            int h = Integer.parseInt(plans[i][1].substring(0,2));
            int m = Integer.parseInt(plans[i][1].substring(3));
            
            int start = h*60 + m;
            int remain = Integer.parseInt(plans[i][2]);
            
            waiting.add(new Task(plans[i][0], start, remain));
        }
        
        int time = waiting.peek().start;
        List<String> ans = new ArrayList<>();
        
        while(!waiting.isEmpty()){
            Task now = waiting.poll();
            
            if(waiting.isEmpty()){
                ans.add(now.name);
                
                while(!paused.isEmpty()){
                    ans.add(paused.pollLast().name);
                }
                break;
            }
            
            int available = waiting.peek().start - now.start;
            
            if(available < now.remain){
                paused.offerLast(new Task(now.name, now.start, now.remain - available));
            }
            else{
                ans.add(now.name);
                
                int remainTime = available - now.remain;
                
                while(remainTime>0 && !paused.isEmpty()){
                    Task resume = paused.pollLast();
                    
                    if(resume.remain <= remainTime){
                        ans.add(resume.name);
                        remainTime -= resume.remain;
                    }else{
                        resume.remain -= remainTime;
                        paused.offerLast(resume);
                        remainTime = 0;
                    }
                }
            }
        }
        String[] answer = new String[ans.size()];
        for(int i=0;i<ans.size();i++){
            answer[i] = ans.get(i);
        }
        
        return answer;
    }
}