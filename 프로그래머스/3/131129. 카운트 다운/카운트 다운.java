class Solution {
    public int[] solution(int target) {
        int[][] dp = new int[100001][2];
        
        for(int i=0;i<=target;i++){
            dp[i][0] = Integer.MAX_VALUE;
        }
        
        for(int i=1;i<=20;i++){
            dp[i][0] = 1;
            dp[i][1] = 1;
            
            dp[i*2][0] = 1;
            dp[i*3][0] = 1;
        }
        
        dp[50][0] = 1;
        dp[50][1] = 1;
        
        
        for(int i=2;i<=target;i++){
            for(int j=1;j<i;j++){
                int temp1 = dp[i-j][0] + dp[j][0];
                int temp2 = dp[i-j][1] + dp[j][1];
                if(dp[i][0] > temp1){
                    dp[i][0] = temp1;
                    dp[i][1] = temp2;
                }else if(dp[i][0] == temp1){
                    dp[i][1] = Math.max(dp[i][1], temp2);
                }
            }
        }
        
        
        
        return new int[]{dp[target][0], dp[target][1]};
    }
}