import java.util.*;

class Solution {
    public long solution(int[] a, int[][] edges) {
        long answer = 0;
        int n = a.length;
        long sum = 0;
        long[] w = new long[n];
        int[] degree = new int[n];
        for(int i=0;i<n;i++){
            sum += a[i];
            w[i] = a[i];
        }
        if(sum!=0)
            return -1;
        
        List<Integer>[] tree = new ArrayList[n];
        for(int i=0;i<n;i++)
            tree[i] = new ArrayList<>();
        
        for(int i=0;i<edges.length;i++){
            int c = edges[i][0];
            int b = edges[i][1];
            tree[c].add(b);
            tree[b].add(c);
            degree[c]++;
            degree[b]++;
        }
        
        Queue<Integer> edge = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(degree[i]==1)
                edge.add(i);
        }
        
        boolean[] visited = new boolean[n];
        
        while(!edge.isEmpty()){
            int now = edge.poll();
            long val = w[now];
            w[now] = 0;
            visited[now] = true;
            
            List<Integer> temp = new ArrayList<>();
            
            for(int next : tree[now]){
                if(!visited[next]){
                    w[next] += val;
                    temp.add(next);
                    answer += Math.abs(val);
                }
            }
            for(int next : temp){
                degree[next]--;
                if(degree[next]==1)
                    edge.add(next);
            }
        }
        
        return answer;
    }
}

/*
a에 있는 모든 값 더해서 0이 되면 되는거?
만약 되면 에지노드부터 0으로 만들어주고 루트 노드로 ㄱㄱ
*/