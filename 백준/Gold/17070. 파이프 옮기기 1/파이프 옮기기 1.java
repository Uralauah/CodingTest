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

		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] { 1, 2, 1 });

		int ans = 0;
		while (!q.isEmpty()) {
			int[] now = q.poll();
			int x = now[0];
			int y = now[1];
			if(x==n && y==n) {
				ans++;
				continue;
			}
			switch(now[2]) {
			case 1:
				if(check(x,y,1,1))
					q.add(new int[] {x,y+1,1});
				if(check(x,y,1,3))
					q.add(new int[] {x+1,y+1,3});
				break;
			case 2:
				if(check(x,y,2,2))
					q.add(new int[] {x+1,y,2});
				if(check(x,y,2,3))
					q.add(new int[] {x+1,y+1,3});
				break;
			case 3:
				if(check(x,y,3,1))
					q.add(new int[] {x,y+1,1});
				if(check(x,y,3,2))
					q.add(new int[] {x+1,y,2});
				if(check(x,y,3,3))
					q.add(new int[] {x+1,y+1,3});
				break;
			}
		}
		
		System.out.println(ans);
	}
}