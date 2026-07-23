import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        
        Deque<int[]> q = new ArrayDeque<>();
        
        int currentWeight = 0;
        
        for(int truck : truck_weights){
            time++;
            
            while(!q.isEmpty() && q.peekFirst()[1] <= time){
                currentWeight -= q.pollFirst()[0];
            }
            
            while(currentWeight + truck > weight){
                time = q.peekFirst()[1];
                
                while(!q.isEmpty() && q.peekFirst()[1] <= time){
                    currentWeight -= q.pollFirst()[0];
                }
            }
            
            currentWeight += truck;
            
            q.add(new int[]{truck, time+bridge_length});
        }
        
        
        return q.peekLast()[1];
    }
}