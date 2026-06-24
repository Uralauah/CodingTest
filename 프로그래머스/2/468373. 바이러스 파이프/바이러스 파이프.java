import java.util.ArrayList;
import java.util.ArrayDeque;

class Solution {
    public int ans = 0, k;
    public ArrayList<Integer> q;
    public boolean[] visited;
    public ArrayList<Integer>[][] arr;
    
    public void dfs(int type, int sum, int cnt){
        if(cnt>=k){
            ans = Math.max(ans, sum);
            return;
        }
        
        ArrayDeque<Integer> bfs = new ArrayDeque<>();
        ArrayList<Integer> temp = new ArrayList<>();
        
        bfs.addAll(q);
        
        while(!bfs.isEmpty()){
            int now = bfs.poll();
            
            for(int next: arr[now][type]){
                if(!visited[next]){
                    visited[next] = true;
                    sum++;
                    
                    q.add(next);
                    bfs.add(next);
                    temp.add(next);
                }
            }
        }
        
        for(int i=1;i<=3;i++){
            dfs(i, sum, cnt+1);
        }
        
        for(int i : temp){
            q.remove(Integer.valueOf(i));
            visited[i] = false;
        }
        
        return;
    }
    
    public int solution(int n, int infection, int[][] edges, int k) {
        int answer = 0;
        this.k = k;
        
        arr = new ArrayList[n+1][4];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=3;j++){
                arr[i][j] = new ArrayList<Integer>();
            }
        }
        
        for(int i=0;i<edges.length;i++){
            int f = edges[i][0];
            int t = edges[i][1];
            int type = edges[i][2];
            
            arr[f][type].add(t);
            arr[t][type].add(f);
        }
        
        q = new ArrayList<>();
        q.add(infection);
        
        visited = new boolean[n+1];
        visited[infection] = true;
        
        for(int i=1;i<=3;i++){
            dfs(i, 1, 0);
        }
        
        return ans;
    }
}