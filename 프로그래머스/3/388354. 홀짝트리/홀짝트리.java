import java.util.ArrayList;
import java.util.HashMap;
import java.util.ArrayDeque;

class Solution {
    public HashMap<Integer,ArrayList<Integer>> tree;
    public boolean[] visited;
    public int a = 0, b = 0;
    
    public void check(int node){
        int A = 0;
        int B = 0;
        
        ArrayDeque<Integer> q = new ArrayDeque<>();
        
        q.add(node);
        
        visited[node] = true;
        while(!q.isEmpty()){
            int now = q.poll();
            
            if(now % 2 == tree.get(now).size()%2)
                A++;
            else
                B++;
            
            for(int i=0;i<tree.get(now).size();i++){
                int next = tree.get(now).get(i);
                if(visited[next])
                    continue;
                
                visited[next] = true;
                q.add(next);
                
            }
        }
        
        if(A==1){
            a++;
        }
        if(B==1)
            b++;
    }
    
    public int[] solution(int[] nodes, int[][] edges) {
        int[] answer = {};
        
        tree = new HashMap<>();
        
        for(int i=0;i<nodes.length;i++){
            tree.put(nodes[i], new ArrayList<>());
        }
        
        for(int i=0;i<edges.length;i++){
            int f = edges[i][0];
            int t = edges[i][1];
            
            tree.get(f).add(t);
            tree.get(t).add(f);
        }
        
        visited = new boolean[1000001];
        
        for(int i=0;i<nodes.length;i++){
            if(visited[nodes[i]])
                continue;
            
            check(nodes[i]);
        }
        
        return new int[]{a,b};
    }
}