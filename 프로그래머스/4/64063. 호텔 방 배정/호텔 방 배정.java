import java.util.*;

class Solution {
    public Map<Long,Long> map;
    
    public long find(long num){
        if(map.containsKey(num)){
            map.put(num,find(map.get(num)));
            return map.get(num);
        }
        map.put(num,num+1);
        return num;
    }
    
    public long[] solution(long k, long[] room_number) {
        int n = room_number.length;
        long[] answer = new long[n];
        map = new HashMap<>();
        
        // map.put(1,2);
        // map.put(1,3);
        // System.out.println(map.get(1));
        
        for(int i=0;i<n;i++){
            long now = room_number[i];
            answer[i] = find(now);
        }
        
        return answer;
    }
}