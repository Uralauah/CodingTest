class Solution {
    public int[][] match;
    public int n, m;
    
    public int[][] rotate(int[][] key){
        int[][] temp = new int[m][m];
        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){
                temp[i][j] = key[m-1-j][i];
            }
        }
        return temp;
    }
    
    public boolean check(){
        for(int i=m-1;i<n+m-1;i++){
            for(int j=m-1;j<n+m-1;j++){
                if(match[i][j]!=1)
                    return false;
            }
        }
        return true;
    }
    
    public boolean solution(int[][] key, int[][] lock) {
        n = lock.length;
        m = key.length;
        
        match = new int[2*(m-1)+n][2*(m-1)+n];
        
        for(int i=m-1;i<m+n-1;i++){
            for(int j=m-1;j<m+n-1;j++){
                match[i][j] = lock[i-(m-1)][j-(m-1)];
            }
        }
        
        for(int r=0;r<4;r++){
            for(int i=0;i<n+m-1;i++){
                for(int j=0;j<n+m-1;j++){
                    for(int k=0;k<m;k++){
                        for(int t=0;t<m;t++){
                            match[i+k][j+t] += key[k][t];
                        }
                    }
                    if(check())
                        return true;
                    for(int k=0;k<m;k++){
                        for(int t=0;t<m;t++){
                            match[i+k][j+t] -= key[k][t];
                        }
                    }
                }
            }
            key = rotate(key);
        }
        
        return false;
    }
}
// 0 0 -> 0 2
// 1 0 -> 0 1
// 2 0 -> 0 0

// 0 1 -> 1 2
// 1 1 -> 1 1
// 2 1 -> 1 0
    
// 0 2 -> 2 2
// 1 2 -> 2 1
// 2 2 -> 2 0