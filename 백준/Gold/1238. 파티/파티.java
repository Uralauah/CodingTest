import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());

		ArrayList<int[]>[] arr = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++)
			arr[i] = new ArrayList<int[]>();

		int[][] dist = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
			dist[i][i] = 0;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());

			arr[from].add(new int[] { to, time });
			dist[from][to] = time;
		}

		for (int i = 1; i <= n; i++) {
			PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2)-> {
				return o1[1] - o2[1];
			});
			pq.add(new int[] { i, 0 });

			while (!pq.isEmpty()) {
				int[] now = pq.poll();

				if (dist[i][now[0]] < now[1])
					continue;

				dist[i][now[0]] = now[1];

				for (int[] next : arr[now[0]]) {
					pq.add(new int[] { next[0], now[1] + next[1] });
				}
			}
		}
		int ans = 0;
		for (int i = 1; i <= n; i++) {
			int sum = dist[i][x] + dist[x][i];
			ans = Math.max(ans, sum);
		}

		System.out.println(ans);

	}
}