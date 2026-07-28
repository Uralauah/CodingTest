class Solution {
    public int answer = Integer.MAX_VALUE;
    public int[][] maze, dir = {{0,1},{0,-1},{1,0},{-1,0}};
    public boolean[][][] visited;
    public int n, m;
    
    public void dfs(int cnt, int rx, int ry, int bx, int by){
        if(cnt>=answer)
            return;
        
        if(maze[rx][ry] == 3 && maze[bx][by] == 4){
            answer = Math.min(answer, cnt);
            return;
        }
        
        for(int r=0;r<(maze[rx][ry] == 3? 1 : 4);r++){
            int nrx = rx;
            int nry = ry;
            
            boolean redFlag = maze[rx][ry] != 3;
            
            if(redFlag){
                nrx = rx + dir[r][0];
                nry = ry + dir[r][1];
                
                if(nrx < 0 || nrx >= n || nry <0 || nry >= m || maze[nrx][nry] == 5 || visited[0][nrx][nry])
                    continue;
                
                visited[0][nrx][nry] = true;
            }
            
            for(int b=0;b<(maze[bx][by] == 4 ? 1 : 4);b++){
                int nbx = bx;
                int nby = by;
                
                boolean blueFlag = maze[bx][by] != 4;
                
                if(blueFlag){
                    nbx = bx + dir[b][0];
                    nby = by + dir[b][1];
                    
                    if(nbx < 0 || nbx >=n || nby < 0 || nby >=m || maze[nbx][nby] == 5 || visited[1][nbx][nby])
                        continue;
                }
                if(nrx == nbx && nry == nby)
                        continue;
                    
                if (nrx == bx && nry == by &&
                    nbx == rx && nby == ry) {
                    continue;
                }
                    
                if (blueFlag)
                    visited[1][nbx][nby] = true;
                
                dfs(cnt + 1, nrx, nry, nbx, nby);
                
                if (blueFlag)
                    visited[1][nbx][nby] = false;
            }
            if(redFlag)    
                visited[0][nrx][nry] = false;
        }
    }
    
    public int solution(int[][] maze) {
        n = maze.length;
        m = maze[0].length;
        this.maze = maze;
        
        visited = new boolean[2][n][m];
        
        int rx=0, ry=0, bx=0, by=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(maze[i][j]==1){
                    rx = i;
                    ry = j;
                }
                if(maze[i][j]==2){
                    bx = i;
                    by = j;
                }
            }
        }
        visited[0][rx][ry] = true;
        visited[1][bx][by] = true;
        
        dfs(0, rx, ry, bx, by);
        
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
}