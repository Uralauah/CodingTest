import java.io.*;
import java.util.*;

class Main {
    public static int n, m;
    public static List<List<Node>> graph;
    public static long[] dist;

    static class Node {
        int to;
        int signalTime;

        public Node(int to, int signalTime) {
            this.to = to;
            this.signalTime = signalTime;
        }

    }
    static class State {
        int index;
        long time;

        public State(int index, long time) {
            this.index = index;
            this.time = time;
        }

    }

    public static void find() {
        PriorityQueue<State> pq = new PriorityQueue<>(Comparator.comparingLong(s -> s.time));
        pq.offer(new State(1, 0));
        dist[1] = 0;

        while (!pq.isEmpty()) {
            State now = pq.poll();

            if (now.time > dist[now.index]) continue;

            for (Node next : graph.get(now.index)) {
                long nextTime;

                if (now.time <= next.signalTime) {
                    nextTime = next.signalTime + 1;
                } else {
                    long wait = ((now.time - next.signalTime + m - 1) / m) * m;
                    nextTime = wait + next.signalTime + 1;
                }

                if (dist[next.to] > nextTime) {
                    dist[next.to] = nextTime;
                    pq.offer(new State(next.to, nextTime));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, i));
            graph.get(b).add(new Node(a, i));
        }

        dist = new long[n + 1];
        Arrays.fill(dist, Long.MAX_VALUE);

        find();
        System.out.println(dist[n]);
    }
}
