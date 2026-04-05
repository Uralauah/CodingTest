import java.util.*;

class Solution {
    public int solution(int[][] land) {
        int answer = 0;
        int n = land.length;
        int m = land[0].length;
        int[] sum = new int[m];
        
        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
        
        boolean[][] visited = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j] || land[i][j]==0)
                    continue;
                
                Queue<int[]> q = new ArrayDeque<>();
                Set<Integer> set = new HashSet<>();
                
                q.add(new int[]{i,j});
                visited[i][j] = true;
                set.add(j);
                int size = 0;
                
                while(!q.isEmpty()){
                    int[] now = q.poll();
                    size++;
                    for(int d=0;d<4;d++){
                        int tx = now[0] + dir[d][0];
                        int ty = now[1] + dir[d][1];
                        
                        if(tx<0 || tx>=n || ty<0 || ty>=m || visited[tx][ty] || land[tx][ty] == 0)
                            continue;
                        
                        visited[tx][ty] = true;
                        if(!set.contains(ty))
                            set.add(ty);
                        q.add(new int[]{tx,ty});
                        
                    }
                }
                for(int next : set)
                    sum[next] += size;
            }
        }
        
        for(int i=0;i<m;i++){
            answer = Math.max(answer, sum[i]);
            System.out.print(sum[i]+" ");
        }
        return answer;
    }
}