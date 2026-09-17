import java.util.*;

class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int n = maze.length;
        int m = maze[0].length;
        int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
        boolean[][] visited = new boolean[n][m];
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{entrance[0], entrance[1], 0});
        visited[entrance[0]][entrance[1]] = true;

        while(!q.isEmpty()){
            int[] now = q.poll();

            if(now[2]!=0 && (now[0] == 0 || now[0] == n-1 || now[1] == 0 || now[1] == m-1))
                return now[2];

            for(int i=0;i<4;i++){
                int tx = now[0] + dir[i][0];
                int ty = now[1] + dir[i][1];

                if(tx<0 || tx>=n || ty<0 || ty>=m || visited[tx][ty] || maze[tx][ty] == '+')
                    continue;

                visited[tx][ty] = true;

                
                q.add(new int[]{tx,ty,now[2]+1});
            }
        }
        return -1;
    }
}