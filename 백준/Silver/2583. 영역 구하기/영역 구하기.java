import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[][] arr = new int[m][n];
		boolean[][] visited = new boolean[m][n];
		int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			for (int y = y1; y < y2; y++) {
				for (int x = x1; x < x2; x++) {
					arr[y][x] = 1;
					visited[y][x] = true;
				}
			}
		}

		List<Integer> ans = new ArrayList<>();

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (visited[i][j])
					continue;

				Queue<int[]> q = new ArrayDeque<>();
				q.add(new int[] { i, j });
				visited[i][j] = true;
				int size = 0;

				while (!q.isEmpty()) {
					int[] now = q.poll();
					size++;
					for (int d = 0; d < 4; d++) {
						int ty = now[0] + dir[d][0];
						int tx = now[1] + dir[d][1];

						if (tx < 0 || tx >= n || ty < 0 || ty >= m || visited[ty][tx] || arr[ty][tx] == 1)
							continue;

						visited[ty][tx] = true;
						q.add(new int[] { ty, tx });
					}
				}
				ans.add(size);
			}
		}
		
		Collections.sort(ans);
		
		System.out.println(ans.size());
		for(int s : ans) {
			System.out.print(s+" ");
		}
	}
}
