import java.util.*;

class Solution {
    public class Node{
        public int num;
        public int dist;
        
        public Node(int num, int dist){
            this.num = num;
            this.dist = dist;
        }
    }
    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = {Integer.MAX_VALUE, Integer.MAX_VALUE};
        
        List<Node>[] arr = new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            arr[i] = new ArrayList<Node>();
        }
        
        Set<Integer> summit = new HashSet<>();
        for(int s : summits){
            summit.add(s);
        }
        
        for(int i=0;i<paths.length;i++){
            int f = paths[i][0];
            int t = paths[i][1];
            int d = paths[i][2];
            
            arr[f].add(new Node(t,d));
            arr[t].add(new Node(f,d));
        }
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)->o1.dist-o2.dist);
        
        int[] intensity = new int[n+1];
        Arrays.fill(intensity,Integer.MAX_VALUE);
        for(int g : gates){
            pq.add(new Node(g,0));
            intensity[g] = 0;
        }
        
        while(!pq.isEmpty()){
            Node now = pq.poll();
            
            if(intensity[now.num]<now.dist)
                continue;
            if(summit.contains(now.num))
                continue;
            
            for(Node next : arr[now.num]){
                int inten = Math.max(next.dist, now.dist);
                if(inten >= intensity[next.num])
                    continue;
                intensity[next.num] = inten;
                pq.add(new Node(next.num, inten));
            }
        }
        
        for(int s : summits){
            if(answer[1] > intensity[s]){
                answer[0] = s;
                answer[1] = intensity[s];
            } else if(answer[1] == intensity[s] && answer[0] > s){
                answer[0] = s;
            }
        }
        
        return answer;
    }
}