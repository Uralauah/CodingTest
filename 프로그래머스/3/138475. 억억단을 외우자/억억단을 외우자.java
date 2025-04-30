import java.util.*;

class Solution {
    
    public int[] solution(int e, int[] starts) {
        int[] answer = new int[starts.length];
        
        int[] count = new int[e + 1];
        
        for (int i = 1; i <= e; i++) {
            for (int j = i; j <= e; j += i) {
                count[j]++;
            }
        }

        int[] maxValue = new int[e + 1];
        int maxNum = e;
        for (int i = e; i >= 1; i--) {
            if (count[i] >= count[maxNum]) {
                maxNum = i;
            }
            maxValue[i] = maxNum;
        }

        for (int i = 0; i < starts.length; i++) {
            answer[i] = maxValue[starts[i]];
        }
        
        return answer;
    }
}