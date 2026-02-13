import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		int[][] arr = new int[n][n];
		int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
		int x = -1;
		int y = -1;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = st.nextToken().charAt(0) - '0';
				if (arr[i][j] == 9) {
					x = i;
					y = j;
					arr[i][j] = 0;
				}
			}
		}

		boolean flag = true;
		int ans = 0;
		int size = 2;
		int ate = 0;

		Queue<int[]> q;
		boolean[][] visited;
		while (flag) {
			flag = false;

			q = new ArrayDeque<int[]>();
			visited = new boolean[n][n];
			q.add(new int[] { x, y, 0, 0 });
			int dist = Integer.MAX_VALUE;

			int tx = Integer.MAX_VALUE;
			int ty = Integer.MAX_VALUE;

			while (!q.isEmpty()) {
				int[] now = q.poll();

				if (now[3] != 0 && now[3] < size && now[2] <= dist) {
					if (now[2] == dist) {
						if (tx == now[0] && now[1] < ty) {
							ty = now[1];
						} else if (now[0] < tx) {
							tx = now[0];
							ty = now[1];
						}
					} else {
						tx = now[0];
						ty = now[1];
						dist = now[2];
					}
					flag = true;
				}

				if (now[2] > dist) {
					break;
				}

				for (int i = 0; i < 4; i++) {
					int nx = now[0] + dir[i][0];
					int ny = now[1] + dir[i][1];

					if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny])
						continue;

					if (arr[nx][ny] > size)
						continue;
					visited[nx][ny] = true;
					q.add(new int[] { nx, ny, now[2] + 1, arr[nx][ny] });
				}
			}

			if (flag) {
				x = tx;
				y = ty;
				ans += dist;
				arr[x][y] = 0;
				ate++;
				if(ate==size) {
					size++;
					ate=0;
				}
				continue;
			}
		}
		System.out.println(ans);
	}
}