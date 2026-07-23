import java.util.*;

class Solution {
    public Map<Integer, Integer> in, totalTimes;
    public int baseFee, baseTime, unitTime, unitFee;
    
    public int calc(int time){
        int fee = baseFee;
        
        time -= baseTime;
        if(time<=0)
            return fee;
        
        fee += (time + unitTime -1) / unitTime * unitFee;
        
        return fee;
    }
    
    public int[] solution(int[] fees, String[] records) {
        this.baseTime = fees[0];
        this.baseFee = fees[1];
        this.unitTime = fees[2];
        this.unitFee = fees[3];
        
        in = new HashMap<>();
        totalTimes = new HashMap<>();
        StringTokenizer st;
        
        for(int i=0;i<records.length;i++){
            st = new StringTokenizer(records[i]);
            
            String timeStr = st.nextToken();
            int carNum = Integer.parseInt(st.nextToken());
            String op = st.nextToken();
            
            int time = Integer.parseInt(timeStr.substring(0,2))*60 + Integer.parseInt(timeStr.substring(3));
            
            if(op.equals("IN")){
                in.put(carNum, time);
            }
            else{
                int entryTime = in.remove(carNum);
                int parkingTime = time - entryTime;

                totalTimes.put(carNum, totalTimes.getOrDefault(carNum, 0) + parkingTime);
            }
            
        }
        
        for(Map.Entry<Integer, Integer> entry : in.entrySet()){
            totalTimes.put(entry.getKey(), totalTimes.getOrDefault(entry.getKey(), 0) + 1439-entry.getValue());
        }
        
        List<Integer> carNums = new ArrayList<>(totalTimes.keySet());
        Collections.sort(carNums);
        
        int[] answer = new int[carNums.size()];
        
        for(int i=0;i<carNums.size();i++){
            answer[i] = calc(totalTimes.get(carNums.get(i)));
        }
        
        return answer;
    }
}