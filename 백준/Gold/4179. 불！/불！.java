import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int[] jihoon = new int[2];

		int[][] arr = new int[r + 2][c + 2];
		int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
		Queue<int[]> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[r + 2][c + 2];
		
		for (int i = 1; i <= r; i++) {
			String input = br.readLine();
			for (int j = 1; j <= c; j++) {
				char n = input.charAt(j - 1);

				if (n == '#')
					arr[i][j] = -1;
				else if (n == 'J') {
					jihoon[0] = i;
					jihoon[1] = j;
					arr[i][j] = 999999;
				} else if (n == 'F') {
					q.add(new int[] { i, j, 0 });
					visited[i][j] = true;
				}else {
					arr[i][j] = 999999;
				}
			}
		}

		for (int i = 0; i <= r + 1; i++) {
			arr[i][0] = -2;
			arr[i][c + 1] = -2;
		}
		for (int i = 0; i <= c + 1; i++) {
			arr[0][i] = -2;
			arr[r + 1][i] = -2;
		}

		while (!q.isEmpty()) {
			int[] now = q.poll();
			int x = now[0];
			int y = now[1];

			arr[x][y] = now[2];

			for (int i = 0; i < 4; i++) {
				int tx = x + dir[i][0];
				int ty = y + dir[i][1];

				if (visited[tx][ty] || arr[tx][ty] == -1 || arr[tx][ty] == -2)
					continue;

				q.add(new int[] { tx, ty, now[2] + 1 });
				visited[tx][ty] = true;
			}
		}
		
		
		int ans = -1;
		visited = new boolean[r+2][c+2];
		q.add(new int[] {jihoon[0],jihoon[1],0});
		visited[jihoon[0]][jihoon[1]] = true;
		while(!q.isEmpty()) {
			if (ans!=-1)
				break;
			
			int[] now = q.poll();
			int x = now[0];
			int y = now[1];
			
			
			for(int i=0;i<4;i++) {
				int tx = x + dir[i][0];
				int ty = y + dir[i][1];
				
				if(arr[tx][ty] == -2) {
					ans = now[2]+1;
					break;
				}
				
				if(visited[tx][ty] || arr[tx][ty] <= now[2]+1)
					continue;
				
				q.add(new int[] {tx,ty,now[2]+1});
				visited[tx][ty] = true;
			}
		}
		
		if(ans==-1)
			System.out.println("IMPOSSIBLE");
		else System.out.println(ans);
	}
}

