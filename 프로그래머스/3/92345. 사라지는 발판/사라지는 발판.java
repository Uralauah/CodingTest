class Solution {
    public int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}}, board;
    public int[][] loc;
    public int answer = 0, n, m;
    
    public boolean check(int r, int c){
        if(board[r][c] == 0)
            return false;
        
        for(int d=0;d<4;d++){
            int tr = r+dir[d][0];
            int tc = c+dir[d][1];
            
            if(tr<0 || tr>=n || tc<0 || tc>=m)
                continue;
            
            if(board[tr][tc]!=0)
                return true;
        }
        
        return false;
    }
    
    public int dfs(int turn){
        int r = loc[turn][0];
        int c = loc[turn][1];
        
        if(!check(r,c)){
            return 0;
        }
        
        int win = Integer.MAX_VALUE;
        int lose = 0;
        
        for(int d=0;d<4;d++){
            int tr = r+dir[d][0];
            int tc = c+dir[d][1];
            
            if(tr<0 || tr>=n || tc<0 || tc>=m || board[tr][tc] == 0)
                continue;
            
            loc[turn][0] = tr;
            loc[turn][1] = tc;
            
            board[r][c] = 0;
            
            int result = dfs((turn+1)%2) + 1;
            
            loc[turn][0] = r;
            loc[turn][1] = c;
            board[r][c] = 1;
            
            if(result % 2==0){
                lose = Math.max(lose, result);
            }
            else{
                win = Math.min(win, result);
            }
        }
        if (win != Integer.MAX_VALUE) {
            return win;
        }
        return lose;
    }
    
    
    public int solution(int[][] board, int[] aloc, int[] bloc) {
        this.board = board;
        loc = new int[2][2];
        for(int i=0;i<2;i++){
            loc[0][i] = aloc[i];
            loc[1][i] = bloc[i];
        }
        n = board.length;
        m = board[0].length;
        
        return dfs(0);
    }
}