import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        int[][] dir = {{1, -1}, {1, 0}, {1, 1}};

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            q.add(new int[]{-1,i,-1,0});
        }
        int ans = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            if (now[0] == n - 1) {
                ans = Math.min(ans, now[3]);
            }

            for (int i = 0; i < 3; i++) {
                if (now[2] == i) {
                    continue;
                }
                int tx = now[0] + dir[i][0];
                int ty = now[1] + dir[i][1];

                if (tx < 0 || tx >= n || ty < 0 || ty >= m) {
                    continue;
                }

                q.add(new int[]{tx, ty, i, now[3]+arr[tx][ty]});
            }
        }

        System.out.println(ans);
    }
}