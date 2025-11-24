import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        Arrays.sort(rocks);
        
        int left = 0;
        int right = distance;
        
        while(left<=right){
            int mid = (left+right)/2;
            
            int sum = 0;
            int prev = 0;
            for(int i=0;i<rocks.length;i++){
                if(rocks[i]-prev<mid){
                    sum++;
                    continue;
                }
                prev = rocks[i];
            }
            if(distance-prev<mid)
                sum++;
            
            if(sum<=n){
                left = mid+1;
            }
            else
                right = mid-1;
        }
        return right;
    }
}