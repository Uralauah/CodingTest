import java.util.*;

class Solution {
    public class Node{
        int num;
        int len;
        
        public Node(int num, int len){
            this.num = num;
            this.len = len;
        }
    }
    
    public int[][] arr;
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        arr = new int[n][n];
        
        for(int i=0;i<costs.length;i++){
            arr[costs[i][0]][costs[i][1]] = costs[i][2];
            arr[costs[i][1]][costs[i][0]] = costs[i][2];
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>(){
            @Override
            public int compare(Node o1, Node o2){
                return o1.len - o2.len;
            }
        });
        
        for(int i=0;i<n;i++){
            if(arr[0][i]==0)
                continue;
            pq.add(new Node(i, arr[0][i]));
        }
        
        Set<Integer> set = new HashSet<>();
    
        set.add(0);
        
        while(!pq.isEmpty()){
            Node now = pq.poll();
            
            if(set.contains(now.num))
                continue;
            set.add(now.num);
            answer += now.len;
            
            for(int i=0;i<n;i++){
                if(arr[now.num][i]==0)
                    continue;
                pq.add(new Node(i, arr[now.num][i]));
            }
        }
        
        return answer;
    }
}