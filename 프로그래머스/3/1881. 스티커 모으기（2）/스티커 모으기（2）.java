class Solution {
    public int solution(int sticker[]) {
        int answer = 0;
        int n = sticker.length;
        
        if(n<=3){
            for(int i=0;i<n;i++){
                answer = Math.max(answer , sticker[i]);
            }
            return answer;
        }
        
        int[] dp = new int[n];
        dp[1] = sticker[1];
        for(int i=2;i<n;i++){
            dp[i] = Math.max(dp[i-1], dp[i-2]+sticker[i]);
        }
        
        answer = dp[n-1];
        
        dp[0] = sticker[0];
        dp[1] = sticker[0];
        for(int i=2;i<n-1;i++){
            dp[i] = Math.max(dp[i-1] , dp[i-2]+sticker[i]);
        }
        
        answer = Math.max(answer , dp[n-2]);

        return answer;
    }
}