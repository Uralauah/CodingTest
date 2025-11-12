import java.util.*;

class Solution {
    public int n,m;
    
    public class Node{
        public int x,y,cnt;
        
        public Node(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    
    public boolean check(int x, int y){
        return x>=0 && x<n && y>=0 && y<m;
    }
    
    public int solution(String[] board) {
        int answer = -1;
        n = board.length;
        m = board[0].length();
        int dx = -1, dy = -1;
        
        char[][] map = new char[n][m];
        Queue<Node> q = new ArrayDeque<>();
        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                char now = board[i].charAt(j);
                if(now=='G'){
                    dx = i;
                    dy = j;
                    map[i][j] = '.';
                    continue;
                }
                else if(now=='R'){
                    q.add(new Node(i,j,0));
                    map[i][j] = '.';
                    continue;
                }
                map[i][j] = now;
            }
        }
        
        boolean[][] visited = new boolean[n][m];
        
        while(!q.isEmpty()){
            Node now = q.poll();
            visited[now.x][now.y] = true;
            
            // System.out.println(now.x+" "+now.y);
            
            if(now.x==dx && now.y==dy){
                answer = now.cnt;
                break;
            }
            
            for(int i=0;i<4;i++){
                int tx = now.x;
                int ty = now.y;
                
                while(check(tx,ty) && map[tx][ty]!='D'){
                    tx += dir[i][0];
                    ty += dir[i][1];
                }
                tx -= dir[i][0];
                ty -= dir[i][1];
                if(visited[tx][ty])
                    continue;
                q.add(new Node(tx, ty, now.cnt+1));
            }
        }
        
        return answer;
    }
}