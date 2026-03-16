import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static int[][] arr;
	public static int n, m;
	public static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	public static boolean[][] visited;

	public static void bfs(int x, int y) {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] { x, y });

		while (!q.isEmpty()) {
			int[] now = q.poll();

			for (int i = 0; i < 4; i++) {
				int tx = now[0] + dir[i][0];
				int ty = now[1] + dir[i][1];

				if (tx < 0 || tx >= n || ty < 0 || ty >= m || visited[tx][ty] || arr[tx][ty] != 1)
					continue;

				visited[tx][ty] = true;
				q.add(new int[] { tx, ty });
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());

			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			arr = new int[n][m];

			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());

				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());

				arr[x][y] = 1;
			}

			visited = new boolean[n][m];

			int ans = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (arr[i][j] == 1 && !visited[i][j]) {
						ans++;
						bfs(i, j);
					}
				}
			}
			
			System.out.println(ans);
		}
	}
}