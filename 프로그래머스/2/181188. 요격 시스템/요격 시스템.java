import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 1;
        
        Arrays.sort(targets, (o1, o2)->{
           if(o1[0] == o2[0])
               return Integer.compare(o1[1], o2[1]);
            return Integer.compare(o1[0], o2[0]);
        });
        
        int end = targets[0][1];
        
        for(int i=1;i<targets.length;i++){
            if(targets[i][0] < end){
                end = Math.min(end, targets[i][1]);
                continue;
            }
            
            end = targets[i][1];
            answer++;
        }
        
        return answer;
    }
}