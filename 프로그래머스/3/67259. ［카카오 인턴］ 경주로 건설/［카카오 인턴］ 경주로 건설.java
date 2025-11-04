import java.util.*;

class Solution {
    public class Node{
        public int x;
        public int y;
        public int d;
        public int cost;
        
        public Node(int x, int y, int d, int cost){
            this.x = x;
            this.y = y;
            this.d = d;
            this.cost = cost;
        }
    }
    
    public int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
    
    public int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;
        
        int n = board.length;
        
        for(int k=0;k<2;k++){
            Queue<Node> q = new ArrayDeque<>();
            q.add(new Node(0,0,k,0));

            int[][] map = new int[n][n];
            for(int i=0;i<n;i++){
                Arrays.fill(map[i],Integer.MAX_VALUE);
            }

            while(!q.isEmpty()){
                Node now = q.poll();
                int x = now.x;
                int y = now.y;
                int d = now.d;

                for(int i=0;i<4;i++){
                    if(d+i==3)
                        continue;
                    int tx = x+dir[i][0];
                    int ty = y+dir[i][1];

                    if(tx<0||tx>=n||ty<0||ty>=n)
                        continue;

                    if(board[tx][ty]==1)
                        continue;
                    int next = 0;
                    int nd;
                    if(i==d){
                        next+=now.cost+100;
                        nd = d;
                    }
                    else{
                        next+=now.cost+600;
                        nd = i;
                    }

                    if(map[tx][ty]>next){
                        map[tx][ty] = next;
                        q.add(new Node(tx,ty,nd,next));
                    }
                }
            }
            answer = Math.min(answer, map[n-1][n-1]);
        }
        
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n;j++){
        //         System.out.print(map[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        
        return answer;
    }
}
//down - x+1 :  1
//right - y+1 : 0
//left - y-1 : 3
//up - x+1 : 2