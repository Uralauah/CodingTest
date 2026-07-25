import java.util.*;

class Solution {
    public int solution(String arr[]) {
        int answer = -1;
        int n = arr.length/2+1;
        int[][] maxDp = new int[n][n];
        int[][] minDp = new int[n][n];
        
        for(int i=0;i<n;i++){
            Arrays.fill(maxDp[i], Integer.MIN_VALUE);
            Arrays.fill(minDp[i], Integer.MAX_VALUE);
        }
        
        for(int i=0;i<n;i++){
            maxDp[i][i] = Integer.parseInt(arr[2*i]);
            minDp[i][i] = Integer.parseInt(arr[2*i]);
        }
        
        for(int i=1;i<n;i++){
            for(int j=i-1;j>=0;j--){
                for(int m=j;m<i;m++){
                    if("-".equals(arr[2*m+1])){
                        maxDp[j][i] = Math.max(maxDp[j][i], maxDp[j][m] - minDp[m+1][i]);
                        minDp[j][i] = Math.min(minDp[j][i], minDp[j][m] - maxDp[m+1][i]);
                    }
                    else{
                        maxDp[j][i] = Math.max(maxDp[j][i], maxDp[j][m] + maxDp[m+1][i]);
                        minDp[j][i] = Math.min(minDp[j][i], minDp[j][m] + minDp[m+1][i]);
                    }
                }
            }
        }
        
        return maxDp[0][n-1];
    }
}