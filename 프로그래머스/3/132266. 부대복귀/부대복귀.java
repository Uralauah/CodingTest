import java.util.*;

class Solution {
    public List<Integer>[] arr;
//     public int dest;
    
//     public bfs(int now){
        
//     }
    
    public class Node{
        public int num;
        public int distance;
        
        public Node(int num, int distance){
            this.num = num;
            this.distance = distance;
        }
    }
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] dist = new int[n+1];
        
        arr = new ArrayList[n+1];
        for(int i=1;i<=n;i++)
            arr[i] = new ArrayList<>();
        
        for(int i=0;i<roads.length;i++){
            arr[roads[i][0]].add(roads[i][1]);
            arr[roads[i][1]].add(roads[i][0]);
        }
        
        // boolean[] visited = new boolean[n+1];
        // visited[destination] = true;
        Arrays.fill(dist,-1);
        dist[destination] = 0;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(destination, 0));
        
        while(q.size()!=0){
            Node now = q.poll();
            int sum = now.distance;
            for(int next : arr[now.num]){
                if(dist[next]!=-1)
                    continue;
                q.add(new Node(next, sum+1));
                dist[next] = sum+1;
            }
        }
        
        int[] answer = new int[sources.length];
        for(int i=0;i<sources.length;i++){
            answer[i] = dist[sources[i]];
        }
        
        return answer;
    }
}

/*
각 지역에서 목표 지역까지의 거리 배열
초기엔 -1
첫번째 source부터 찾으면서 업데이트
다음에 찾을 때 -1 아니면 바로 가져오고 -1이면 새로 탐색

----
그냥 destination 부터 모든 경로 계산??
*/