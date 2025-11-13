import java.util.*;

class Solution {
    public int n, m;
    public boolean[][] visited;
    public List<Integer> arr = new ArrayList<>();
    public int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}}, map;
    
    public int find(int x, int y){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x,y});
        int sum = map[x][y];
        visited[x][y] = true;
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            
            for(int i=0;i<4;i++){
                int tx = now[0]+dir[i][0];
                int ty = now[1]+dir[i][1];
                
                if(check(tx,ty) && !visited[tx][ty] && map[tx][ty]!=0){
                    sum+=map[tx][ty];
                    visited[tx][ty] = true;
                    q.add(new int[]{tx,ty});
                }
            }
        }
        return sum;
    }
    
    public boolean check(int x, int y){
        return x>=0 && x<n && y>=0 && y<m;
    }
    
    public int[] solution(String[] maps) {
        int[] answer = {};
        n = maps.length;
        m = maps[0].length();
        map = new int[n][m];
        visited = new boolean[n][m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                char now = maps[i].charAt(j);
                if(now=='X'){
                    map[i][j] = 0;
                    continue;
                }
                map[i][j] = now - '0';
            }
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j] && map[i][j]!=0){
                    arr.add(find(i,j));
                }
            }
        }
        if(arr.size()>0){
            answer = new int[arr.size()];
            for(int i=0;i<arr.size();i++){
                answer[i] = arr.get(i);
            }
            Arrays.sort(answer);
        }
        else{
            answer = new int[]{-1};
        }
        return answer;
    }
}