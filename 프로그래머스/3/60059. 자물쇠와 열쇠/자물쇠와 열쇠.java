class Solution {
    public int[][] match;
    public int n,m;
    
    public boolean check(){
        for(int i=m-1;i<n+m-1;i++){
            for(int j=m-1;j<n+m-1;j++)
                if(match[i][j]!=1)
                    return false;
        }
        return true;
    }
    
    public int[][] rotate(int[][] key){
        int[][] temp = new int[m][m];
        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){
                temp[j][m-1-i] = key[i][j];
            }
        }
        return temp;
    }
    
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        
        n = lock.length;
        m = key.length;
        
        match = new int[n+(m-1)*2][n+(m-1)*2];
        for(int i=m-1;i<n+m-1;i++){
            for(int j=m-1;j<n+m-1;j++){
                match[i][j] = lock[i-(m-1)][j-(m-1)];
            }
        }
        
        for(int i=0;i<4;i++){
            for(int j=0;j<n+m-1;j++){
                for(int k=0;k<n+m-1;k++){
                    for(int a=0;a<m;a++){
                        for(int b=0;b<m;b++){
                            match[j+a][k+b] += key[a][b];
                        }
                    }
                    if(check())
                        return true;
                    for(int a=0;a<m;a++){
                        for(int b=0;b<m;b++){
                            match[j+a][k+b] -= key[a][b];
                        }
                    }
                    
                }
            }
            key = rotate(key);
        }
        
        return answer;
    }
}