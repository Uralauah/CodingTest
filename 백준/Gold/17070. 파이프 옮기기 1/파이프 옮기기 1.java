import java.io.*;
import java.util.*;

public class Main {

	public static int[][] map;
	public static int n;

	public static boolean check(int x, int y, int dir, int next) {
		if (dir == 1) {
			if (next == 1 && map[x][y + 1] != 1) {
				return true;
			}
			if (next == 3 && map[x][y + 1] != 1 && map[x + 1][y + 1] != 1 && map[x + 1][y] != 1) {
				return true;
			}
		}

		else if (dir == 2) {
			if (next == 2 && map[x + 1][y] != 1) {
				return true;
			}
			if (next == 3 && map[x][y + 1] != 1 && map[x + 1][y + 1] != 1 && map[x + 1][y] != 1) {
				return true;
			}
		}

		else if (dir == 3) {
			if (next == 1 && map[x][y + 1] != 1) {
				return true;
			}
			if (next == 2 && map[x + 1][y] != 1)
				return true;
			if (next == 3 && map[x][y + 1] != 1 && map[x + 1][y + 1] != 1 && map[x + 1][y] != 1)
				return true;
		}

		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		map = new int[n + 2][n + 2];

		StringTokenizer st;
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				map[i][j] = st.nextToken().charAt(0) - '0';
			}
		}

		for (int i = 0; i <= n + 1; i++) {
			map[i][0] = 1;
			map[i][n + 1] = 1;
			map[0][i] = 1;
			map[n + 1][i] = 1;
		}

		int[][][] dp = new int[3][n + 2][n + 2];

		dp[0][1][2] = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (dp[0][i][j] > 0) {
					if (check(i, j, 1, 1))
						dp[0][i][j + 1] += dp[0][i][j];
					if (check(i, j, 1, 3))
						dp[2][i + 1][j + 1] += dp[0][i][j];
				}
				if (dp[1][i][j] > 0) {
					if (check(i, j, 2, 2))
						dp[1][i + 1][j] += dp[1][i][j];
					if (check(i, j, 2, 3))
						dp[2][i + 1][j + 1] += dp[1][i][j];
				}
				if(dp[2][i][j]>0) {
					if(check(i,j,3,1))
						dp[0][i][j+1]+=dp[2][i][j];
					if(check(i,j,3,2))
						dp[1][i+1][j]+=dp[2][i][j];
					if(check(i,j,3,3))
						dp[2][i+1][j+1]+=dp[2][i][j];
				}
			}
		}

		System.out.println(dp[0][n][n]+dp[1][n][n]+dp[2][n][n]);
	}
}