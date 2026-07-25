import java.util.*;

class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;

        boolean[][] visited = new boolean[n][1<<n];

        Deque<int[]> q = new ArrayDeque<>();
        for(int i=0;i<n;i++){
            q.add(new int[]{i, (1<<i), 0});
        }

        while(!q.isEmpty()){
            int[] now = q.poll();

            for(int i=0;i<graph[now[0]].length;i++){
                int next = graph[now[0]][i];
                int nextMask = now[1]|(1<<next);

                if(Integer.bitCount(nextMask) == n)
                    return now[2]+1;

                if(visited[next][nextMask])
                    continue;
                
                visited[next][nextMask] = true;
                q.add(new int[]{next, nextMask, now[2]+1});
            }
        }
        return 0;
    }
}