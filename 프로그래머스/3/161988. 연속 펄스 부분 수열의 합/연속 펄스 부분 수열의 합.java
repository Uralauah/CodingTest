import java.util.*;

class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        int len = sequence.length;
        long[] sum = new long[len+1];
        
        sum[0] = sequence[0];
        sum[len] = 0;
        for(int i=1;i<len;i++){
            if(i%2==0)
                sum[i] = sum[i-1]+sequence[i];
            else
                sum[i] = sum[i-1]-sequence[i];
        }
        
//         for(int i=0;i<len;i++){
//             System.out.print(sum[i]+" ");
//         }
        
        Arrays.sort(sum);
        answer = sum[len] - sum[0];
        
        return answer;
    }
}

/*
2 -3 -6 -1 3 1 2 -4 
2 -1 -7 -8 -5 -4 -2 -6
    
-2 3 6 1 -3 -1 -2 4
-2 1 7 8 5 4 2 6
    */
    