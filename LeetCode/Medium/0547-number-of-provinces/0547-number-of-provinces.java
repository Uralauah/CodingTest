import java.util.*;

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];

        Deque<Integer> q = new ArrayDeque<>();
        int ans = 0;

        for(int i=0;i<n;i++){
            if(!visited[i]){
                ans++;
                visited[i] = true;
                q.add(i);

                while(!q.isEmpty()){
                    int now = q.poll();
                    for(int j=0;j<n;j++){
                        if(visited[j] || now==j)
                            continue;

                        if(isConnected[now][j] == 1){
                            visited[j] = true;
                            q.add(j);
                        }
                    }
                }
            }
        }
        return ans;
    }
}