import java.util.*;

class Solution {
    public int orangesRotting(int[][] grid) {
        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
        int n = grid.length;
        int m = grid[0].length;

        Deque<int[]> q = new ArrayDeque<>();

        int ans = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i,j,0});
                    grid[i][j] = 0;
                }
            }
        }

        while(!q.isEmpty()){
            int[] now = q.poll();
            ans = Math.max(ans, now[2]);

            for(int d=0;d<4;d++){
                int tx = now[0] + dir[d][0];
                int ty = now[1] + dir[d][1];

                if(tx<0 || tx>=n || ty<0 || ty>=m || grid[tx][ty] == 0)
                    continue;
                
                grid[tx][ty] = 0;
                q.add(new int[]{tx,ty,now[2]+1});
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] != 0)
                    return -1;
            }
        }

        return ans;
    }
}