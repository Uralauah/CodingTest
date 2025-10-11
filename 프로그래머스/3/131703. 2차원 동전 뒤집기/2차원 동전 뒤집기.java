class Solution {
    public int ans = Integer.MAX_VALUE;
    public int col, row;
    public int[][] diff;
    
    public void calc(int r, int c, int sum){
        if(r==row){
            if(c==col){
                if(check())
                    ans = Math.min(ans, sum);
                return;    
            }
            
            calc(r, c+1, sum);
            
            flip(c,1);
            calc(r,c+1, sum+1);
            flip(c,1);
            
            return;
        }
        
        calc(r+1, c, sum);
            
        flip(r,0);
        calc(r+1,c,sum+1);
        flip(r,0);
    }
    
    public void flip(int x, int axis){
        if(axis == 0){
            for(int i=0;i<col;i++){
                diff[x][i] = diff[x][i] == 0 ? 1 : 0;
            }
        }
        else{
            for(int i=0;i<row;i++){
                diff[i][x] = diff[i][x] == 0 ? 1 : 0;
            }
        }
    }
    
    public boolean check(){
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(diff[i][j]!=0)
                    return false;
            }
        }
        return true;
    }
    
    public int solution(int[][] beginning, int[][] target) {
        int answer = 0;
        col = beginning[0].length;
        row = beginning.length;
        diff = new int[row][col];
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                diff[i][j] = beginning[i][j]==target[i][j] ? 0 : 1;
            }
        }
        
        calc(0,0,0);
        
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}