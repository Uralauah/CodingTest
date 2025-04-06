import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static class Node {
        private int x;
        private int dist;

        public Node(int x, int dist) {
            this.x = x;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int[][] road = new int[n][n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            road[s][e] = d;
            road[e][s] = d;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.dist - o2.dist;
            }
        });

        pq.add(new Node(y, 0));
        boolean[] visited = new boolean[n];
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[y] = 0;
        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (visited[now.x]) {
                continue;
            }
            visited[now.x] = true;

            for (int i = 0; i < n; i++) {
                if (road[now.x][i] != 0 && !visited[i]) {
                    dist[i] = Math.min(dist[i], road[now.x][i] + dist[now.x]);
                    pq.add(new Node(i, dist[i]));
                }
            }
        }

        Arrays.sort(dist);

        int ans = 1;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println(-1);
                return;
            }

            if (temp + dist[i] * 2 > x) {
                ans ++;
                temp = 0;
            }
            if(dist[i]*2>x){
                System.out.println(-1);
                return;
            }

            temp += dist[i]*2;
        }
        System.out.println(ans);
    }
}