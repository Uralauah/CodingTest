import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] priorities = new int[10];
            Queue<int[]> q = new ArrayDeque<>();

            st = new StringTokenizer(br.readLine());
            int max = 0;
            for (int i = 0; i < n; i++) {
                int priority = Integer.parseInt(st.nextToken());

                priorities[priority]++;
                q.add(new int[]{i, priority});
                max = Math.max(max, priority);
            }

            int cnt = 0;
            while (!q.isEmpty()) {
                int[] now = q.poll();

                if (now[1] != max) {
                    q.add(now);
                    continue;
                }

                cnt++;
                priorities[now[1]]--;

                if (now[0] == m) {
                    break;
                }

                while (max > 0 && priorities[max] == 0) {
                    max--;
                }
            }

            System.out.println(cnt);
        }
    }
}