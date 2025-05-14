import java.util.*;
class Solution {
    public int solution(int[] cookie) {
        int answer = -1;
        
        for(int i=0;i<cookie.length;i++){
            int ridx = i;
            int lidx = i;
            int rsum = 0;
            int lsum = cookie[i];
            
            while(true){
                if(rsum==lsum && answer < rsum){
                    answer = rsum;
                }
                else if(rsum <= lsum && ridx <cookie.length-1){
                    rsum += cookie[++ridx];
                }
                else if(rsum > lsum && lidx > 0){
                    lsum += cookie[--lidx];
                } else
                    break;
            }
            
            
        }
        return answer == -1 ? 0: answer;
    }
}