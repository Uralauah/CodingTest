
import java.io.*;
import java.util.*;

public class Main {
	public static boolean[][] visited;
	public static int[][][] dir = { { { 0, 1 }, { -1, 0 } }, { { 0, 1 }, { 1, 0 } }, { { 0, -1 }, { 1, 0 } },
			{ { 0, -1 }, { -1, 0 } } };;
	public static int[][] arr;
	public static int N, M, ans = 0;

	public static void dfs(int idx, int sum) {
		if (idx == N * M) {
			ans = Math.max(ans, sum);
			return;
		}

		int r = idx / M;
		int c = idx % M;

		if (visited[r][c]) {
			dfs(idx + 1, sum);
			return;
		}
		
		dfs(idx+1,sum);

		for (int i = 0; i < 4; i++) {
			int r1 = r + dir[i][0][0];
			int c1 = c + dir[i][0][1];

			int r2 = r + dir[i][1][0];
			int c2 = c + dir[i][1][1];

			if (r1 < 0 || r1 >= N || c1 < 0 || c1 >= M)
				continue;
			if (r2 < 0 || r2 >= N || c2 < 0 || c2 >= M)
				continue;
			
			if(visited[r1][c1] || visited[r2][c2])
				continue;
			
			visited[r1][c1] = true;
			visited[r2][c2] = true;
			visited[r][c] = true;
			
			int temp = arr[r][c]*2 + arr[r1][c1] + arr[r2][c2];
			
			dfs(idx+1,sum+temp);
			
			visited[r1][c1] = false;
			visited[r2][c2] = false;
			visited[r][c] = false;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visited = new boolean[N][M];
		dfs(0,0);
		System.out.println(ans);
	}
}