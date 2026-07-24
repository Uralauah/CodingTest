import java.util.*;

class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int answer = 0;
        int alt = 0;
        int cot = 0;
        int minAlp = Integer.MAX_VALUE;
        int minCop = Integer.MAX_VALUE;
        
        for(int i=0;i<problems.length;i++){
            alt = Math.max(alt, problems[i][0]);
            cot = Math.max(cot, problems[i][1]);
        }
        
        alp = Math.min(alp, alt);
        cop = Math.min(cop, cot);
        
        int[][] dp = new int[alt+1][cot+1];
        for(int i=alp;i<=alt;i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        
        dp[alp][cop] = 0;
        
        for(int i=alp; i<=alt; i++){
            for(int j=cop; j<=cot; j++){
                if(dp[i][j] == Integer.MAX_VALUE)
                    continue;
                
                if(i<alt){
                    dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j]+1);
                }
                if(j<cot){
                    dp[i][j+1] = Math.min(dp[i][j+1], dp[i][j]+1);
                }
                
                for(int[] problem : problems){
                    if(i<problem[0] || j<problem[1])
                        continue;
                    
                    int ni = Math.min(i+problem[2], alt);
                    int nj = Math.min(j+problem[3], cot);
                    
                    dp[ni][nj] = Math.min(dp[ni][nj], dp[i][j] + problem[4]);
                }
            }
        }
        
        
        return dp[alt][cot];
    }
}