class Solution {
    public long solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        long[][] map = new long[n][m];
        for(int i=0;i<puddles.length;i++){
            map[puddles[i][1]-1][puddles[i][0]-1] = -1;
        }
        
        map[0][0] = 1;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(map[i][j] == -1)
                    continue;
                
                if(i+1<n && map[i+1][j] != -1)
                    map[i+1][j] = (map[i+1][j] + map[i][j]) % 1000000007;
                if(j+1<m && map[i][j+1] != -1)
                    map[i][j+1] = (map[i][j+1] + map[i][j]) % 1000000007;
            }
        }
        
        return map[n-1][m-1] % 1000000007;
    }
}