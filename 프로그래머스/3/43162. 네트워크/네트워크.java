import java.util.*;
class Solution {
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        
        for(int i=0;i<n;i++){
            if(!visited[i]){
                answer++;
                Queue<Integer> q = new LinkedList<>();
                
                q.add(i);
                while(!q.isEmpty()){
                    int now = q.poll();
                    
                    for(int j=0;j<n;j++){
                        if(computers[now][j]==1&&!visited[j]){
                            visited[j] = true;
                            q.add(j);
                        }
                    }
                }
            }
        }
        return answer;
    }
}