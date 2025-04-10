import java.util.*;

class Solution {
    public Map<String,Integer> map;
    
    public void find(char[] order, int idx, int len, StringBuilder sb){
        if(sb.length() == len){
            map.put(sb.toString(), map.getOrDefault(sb.toString(),0)+1);
            return;
        }
        
        for(int i=idx;i<order.length;i++){
            sb.append(order[i]);
            find(order, i+1, len, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        
        ArrayList<String> arr = new ArrayList<>();
        
        
        for(int i=0;i<course.length;i++){
            map = new HashMap<>();
            for(int j=0;j<orders.length;j++){
                char[] order = orders[j].toCharArray();
                Arrays.sort(order);
                find(order, 0, course[i], new StringBuilder());
            }
            
            int max = 0;
            for(int val : map.values()){
                max = Math.max(max, val);
            }
            
            if (max >= 2) {
                for (Map.Entry<String, Integer> entry : map.entrySet()) {
                    if (entry.getValue() == max) {
                        arr.add(entry.getKey());
                    }
                }
            }
        }
        
        answer = arr.toArray(new String[0]);
        Arrays.sort(answer);
        return answer;
    }
}