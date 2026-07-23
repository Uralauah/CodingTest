import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        Deque<String> q = new ArrayDeque<>();
        
        for(String city : cities){
            city = city.toLowerCase();
            if(q.contains(city)){
                answer+=1;
                
                q.remove(city);
                q.offerLast(city);
            }
            else{
                answer+=5;
                
                if (cacheSize == 0) {
                    continue;
                }
                
                if(q.size()>=cacheSize){
                    q.pollFirst();
                }
                q.offerLast(city);
            }
        }
        return answer;
    }
}