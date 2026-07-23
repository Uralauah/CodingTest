import java.util.*;

class Solution {
    public int[] solution(String msg) {
        
        Map<String, Integer> map = new HashMap<>();
        
        for(int i=0;i<26;i++){
            map.put(String.valueOf((char)('A'+i)), i+1);
        }
        int len = 27;
        
        List<Integer> ans = new ArrayList<>();
        
        int i=0;
        while(i<msg.length()){
            int idx = i+1;
            while(idx<=msg.length()&&map.containsKey(msg.substring(i,idx))){
                idx++;
            }
            ans.add(map.get(msg.substring(i,idx-1)));
            
            if(idx<=msg.length())
                map.put(msg.substring(i,idx),len++);
            
            i = idx-1;
        }
        
        int[] answer = new int[ans.size()];
        for(i=0;i<ans.size();i++){
            answer[i] = ans.get(i);
        }
        return answer;
    }
}