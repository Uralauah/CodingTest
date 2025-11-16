class Solution {
    public int[][] dungeons;
    public boolean[] visited;
    public int n, answer;
    
    public void find(int remain, int idx, int sum){
        remain -= dungeons[idx][1];
        boolean flag = false;
        for(int i=0;i<n;i++){
            if(!visited[i] && dungeons[i][0]<=remain){
                visited[i] = true;
                find(remain, i, sum+1);
                flag = true;
                visited[i] = false;
            }
        }
        if(!flag){
            answer = Math.max(answer, sum);
        }
    }
    
    public int solution(int k, int[][] dungeons) {
        answer = -1;
        n = dungeons.length;
        this.dungeons = dungeons;
        visited = new boolean[n];
        for(int i=0;i<n;i++){
            if(k>=dungeons[i][0]){
                visited[i] = true;
                find(k, i, 1);
                visited[i] = false;
            }
        }
        return answer;
    }
}