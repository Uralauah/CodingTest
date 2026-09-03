import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        int n = elements.length;
        int[] temp = new int[n*2];
        for(int i=0;i<n;i++){
            temp[i] = elements[i];
            temp[n+i] = elements[i];
        }
        
        for(int i=0;i<n;i++){
            for(int j=1;j<=n;j++){
                int t = 0;
                for(int k=0;k<j;k++){
                    t+=temp[i+k];
                }
                set.add(t);
            }
        }
        
        return set.size();
    }
}