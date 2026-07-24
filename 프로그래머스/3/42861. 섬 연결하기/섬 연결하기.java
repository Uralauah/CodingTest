import java.util.*;

class Solution {
    public int[] parent;
    
    public int find(int a){
        if(parent[a] == a)
            return a;
        
        return parent[a] = find(parent[a]);
    }
    
    public void union(int a, int b){
        a = find(a);
        b = find(b);
        
        if(a!=b){
            parent[b] = a;
        }
    }
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        parent = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
        }
        
        Arrays.sort(costs, (a,b)-> Integer.compare(a[2], b[2]));
        
        int cnt = 0;
        for(int i=0;i<costs.length;i++){
            int a = costs[i][0];
            int b = costs[i][1];
            
            if(find(a) == find(b))
                continue;
            
            union(a,b);
            cnt++;
            answer += costs[i][2];
            
            if(cnt == n-1)
                break;
        }
        
        return answer;
    }
}