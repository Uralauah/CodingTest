class Solution {
    public int answer = 0, k, n;
    public int[][] dungeons;
    public boolean[] visited;
    
    public void find(int remain, int sum){
        boolean flag = false;
        
        for(int i=0;i<n;i++){
            if(!visited[i] && dungeons[i][0] <= remain){
                visited[i] = true;
                flag = true;
                find(remain-dungeons[i][1], sum+1);
                visited[i] = false;
            }
        }
        
        if(!flag){
            answer = Math.max(answer, sum);
        }
    }
    
    public int solution(int k, int[][] dungeons) {
        this.k = k;
        this.n = dungeons.length;
        this.dungeons = dungeons;
        
        visited = new boolean[n];
        find(k,0);
        
        return answer;
    }
}