import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer;
        
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for(int i=0;i<progresses.length;i++){
            int time = (100 - progresses[i] + speeds[i] -1)/speeds[i];
            q.add(time);
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        while(!q.isEmpty()){
            int now = q.pollFirst();
            int cnt = 1;
            while(!q.isEmpty() && q.peekFirst() <= now){
                q.pollFirst();
                cnt++;
            }
            ans.add(cnt);
        }
        
        answer = new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            answer[i] = ans.get(i);
        }
        return answer;
    }
}