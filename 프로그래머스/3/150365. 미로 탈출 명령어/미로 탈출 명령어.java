import java.util.*;

class Solution {
    public int[][] dir = {{1,0},{0,-1},{0,1},{-1,0}};
    public String[] op = {"d","l","r","u"};
    
    public int dist(int x1, int y1, int x2, int y2){
        return Math.abs(x1-x2) + Math.abs(y1 - y2);
    }
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        int distance = dist(x,y,r,c);
        
        if(distance > k)
            return "impossible";
        
        StringBuilder ans = new StringBuilder();
        
        int curX = x;
        int curY = y;
        
        for(int i=0;i<k;i++){
            boolean moved = false;
            
            for(int d=0;d<4;d++){
                int nextX = curX + dir[d][0];
                int nextY = curY + dir[d][1];
                
                if(nextX<1 || nextX>n || nextY<1 || nextY>m)
                    continue;
                
                int nextDist = dist(nextX, nextY, r, c);
                
                if(nextDist <= k-i-1){
                    ans.append(op[d]);
                    curX = nextX;
                    curY = nextY;
                    moved = true;
                    break;
                }
            }
            
            if(!moved)
                return "impossible";
        }
        
        return ans.toString();
    }
}