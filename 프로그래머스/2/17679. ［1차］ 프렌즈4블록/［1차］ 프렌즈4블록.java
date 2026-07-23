class Solution {
    public char[][] arr;
    public boolean[][] removed;
    
    public boolean isRemovable(char now, int x, int y){
        return arr[x+1][y] == now && arr[x][y+1] == now && arr[x+1][y+1] == now;
    }
    
    public void mark(int x, int y){
        removed[x][y] = true;
        removed[x+1][y] = true;
        removed[x][y+1] = true;
        removed[x+1][y+1] = true;
    }
    
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        
        arr = new char[m][n];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length();j++){
                arr[i][j] = board[i].charAt(j);
            }
        }
        
        
        boolean flag = true;
        
        while(flag){
            removed = new boolean[m][n];
            flag = false;
            for(int i=0;i<m-1;i++){
                for(int j=0;j<n-1;j++){
                    if(arr[i][j] != '.' && isRemovable(arr[i][j], i, j)){
                        mark(i,j);
                        flag = true;
                    }
                }
            }
            
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(removed[i][j]){
                        arr[i][j] = '.';
                        answer++;
                    }
                }
            }
            
            for(int j=0;j<n;j++){
                int temp = m-1;
                for(int i=m-1;i>=0;i--){
                    if(arr[i][j] != '.'){
                        arr[temp][j] = arr[i][j];
                        
                        if(temp!=i){
                            arr[i][j] = '.';
                        }
                        
                        temp--;
                    }
                }
            }
        }
        return answer;
    }
}