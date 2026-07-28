import java.util.*;

class Solution {
    public int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    
    public int solution(int[][] land) {
        int answer = 0;
        int n = land.length;
        int m = land[0].length;
        
        int idx = 2;
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(land[i][j]!=1)
                    continue;
                
                Deque<int[]> q = new ArrayDeque<>();
                q.add(new int[]{i,j});
                land[i][j] = idx;
                int sum = 1;
                
                while(!q.isEmpty()){
                    int[] now = q.poll();
                    
                    for(int d=0;d<4;d++){
                        int tx = now[0] + dir[d][0];
                        int ty = now[1] + dir[d][1];
                        
                        if(tx<0 || tx>=n || ty<0 || ty>=m || land[tx][ty]!=1)
                            continue;
                        
                        sum++;
                        q.add(new int[]{tx,ty});
                        land[tx][ty] = idx;
                    }
                }
                map.put(idx, sum);
                idx++;
            }
        }
        
        for(int i=0;i<m;i++){
            Set<Integer> s = new HashSet<>();
            int temp = 0;
            for(int j=0;j<n;j++){
                if(land[j][i] >= 2 && !s.contains(land[j][i])){
                    temp+=map.get(land[j][i]);
                    s.add(land[j][i]);
                }
            }
            answer = Math.max(answer, temp);
        }
        
        return answer;
    }
}