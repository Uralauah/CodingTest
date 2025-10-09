import java.util.*;

class Solution {
    public int solution(int n, int[][] lighthouse) {
        int answer = 0;
        
        List<Integer>[] arr = new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            arr[i] = new ArrayList<>();
        }
        
        for(int[] now : lighthouse){
            arr[now[0]].add(now[1]);
            arr[now[1]].add(now[0]);
        }
        
        int[] deg = new int[n+1];
        Deque<Integer> q = new ArrayDeque<>();
        
        for(int i=1;i<=n;i++){
            deg[i] = arr[i].size();
            if(deg[i]==1)
                q.add(i);
        }
        
        boolean[] on = new boolean[n+1];
        
        while(!q.isEmpty()){
            int leaf = q.poll();
            if(deg[leaf]!=1)
                continue;
            
            int parent = -1;
            for(int p : arr[leaf]){
                if(deg[p]>0){
                    parent = p;
                    break;
                }
            }
            if(parent==-1){
                deg[leaf] = 0;
                continue;
            }
            
            if(!on[parent]){
                on[parent] = true;
                answer++;
            }
            
            for(int nb : arr[parent]){
                if(deg[nb]>0){
                    deg[nb]--;
                    if(deg[nb]==1)
                        q.add(nb);
                }
            }
            deg[parent] = 0;
        }
        
        return answer;
    }
}