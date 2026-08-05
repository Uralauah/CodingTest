import java.util.*;

class Solution {
    public int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    
    public int solution(String[] maps) {
        int answer = 0;
        int n = maps.length;
        int m = maps[0].length();
        boolean[] found = new boolean[2];
        boolean[][][] visited = new boolean[2][n][m];
        
        Deque<int[]> q = new ArrayDeque<>();
        
        char[][] map = new char[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                map[i][j] = maps[i].charAt(j);
                if(map[i][j]=='S'){
                    q.add(new int[]{i,j,0,0});
                    visited[0][i][j] = true;
                }
                if(map[i][j]=='L'){
                    q.add(new int[]{i,j,0,1});
                    visited[1][i][j] = true;
                }
            }
        }
        
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            if(found[now[3]])
                continue;
            
            for(int d=0;d<4;d++){
                int tx = now[0] + dir[d][0];
                int ty = now[1] + dir[d][1];
                
                if(tx < 0 || tx >= n || ty < 0 || ty >= m || visited[now[3]][tx][ty] || map[tx][ty] == 'X')
                    continue;
                
                if(now[3] == 0 && map[tx][ty] == 'L'){
                    answer += now[2] + 1;
                    found[0] = true;
                    continue;
                }
                if(now[3] == 1 && map[tx][ty] == 'E'){
                    answer += now[2] + 1;
                    found[1] = true;
                    continue;
                }
                q.add(new int[]{tx,ty,now[2]+1, now[3]});
                visited[now[3]][tx][ty] = true;
            }
        }
        
        if(!found[0] || !found[1])
            return -1;
        
        return answer;
    }
}