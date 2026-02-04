import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

class Solution {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int[][] dir = { { 0, 1 }, { 0, -1 }, { -1, 0 } };

		for (int testcase = 1; testcase <= 10; ++testcase) {
			sc.nextInt();
			Queue<int[]> q = new ArrayDeque<>();
			int[][] map = new int[100][100];
			
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					map[i][j] = sc.nextInt();

					if (map[i][j] == 2) {
						q.add(new int[] { i, j });
					}
				}
			}

			int ans = -1;
			
			while (!q.isEmpty()) {
				int[] now = q.poll();
				if (now[0] == 0) {
					ans = now[1];
					break;
				}
				map[now[0]][now[1]] = 0;

				for (int i = 0; i < 3; i++) {
					int tx = now[0] + dir[i][0];
					int ty = now[1] + dir[i][1];

					if (tx < 0 || tx >= 100 || ty < 0 || ty >= 100)
						continue;

					if (map[tx][ty] == 1) {
						q.add(new int[] { tx, ty });
						break;
					}
				}
			}

			System.out.println("#" + testcase + " " + ans);
		}

		sc.close();
	}
}