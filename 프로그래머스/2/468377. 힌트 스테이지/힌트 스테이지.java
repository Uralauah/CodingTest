class Solution {
    public int ans = Integer.MAX_VALUE, n;
    public int[] cnt;
    public int[][] cost, hint;
    
    public void dfs(int idx, int sum){
        sum += cnt[idx] >= n ? cost[idx][n-1] : cost[idx][cnt[idx]];
        
        if(idx == n-1){
            ans = Math.min(ans, sum);
            return;
        }
        
        for(int i=1;i<hint[0].length;i++){
            cnt[hint[idx][i]-1]++;
        }
        
        dfs(idx+1, sum+hint[idx][0]);
        
        for(int i=1;i<hint[0].length;i++){
            cnt[hint[idx][i]-1]--;
        }
        
        dfs(idx+1, sum);
    }
    
    public int solution(int[][] cost, int[][] hint) {
        this.cost = cost;
        this.hint = hint;
        n = cost.length;
        cnt = new int[n];
        
        dfs(0,0);
        return ans;
    }
}