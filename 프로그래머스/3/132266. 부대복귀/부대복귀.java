import java.util.*;

class Solution {
    public List<Integer>[] arr;
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] dist = new int[n+1];
        
        arr = new ArrayList[n+1];
        for(int i=1;i<=n;i++)
            arr[i] = new ArrayList<>();
        
        for(int i=0;i<roads.length;i++){
            arr[roads[i][0]].add(roads[i][1]);
            arr[roads[i][1]].add(roads[i][0]);
        }
        
        Arrays.fill(dist,-1);
        dist[destination] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(destination);
        
        while(q.size()!=0){
            int now = q.poll();
            for(int next : arr[now]){
                if(dist[next]!=-1)
                    continue;
                q.add(next);
                dist[next] = dist[now]+1;
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