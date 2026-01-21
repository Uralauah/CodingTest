import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());

		int[][] dir = {{0,1,0},{0,-1,0},{0,0,1},{0,0,-1},{1,0,0},{-1,0,0}};

		int[][][] arr = new int[H + 2][M + 2][N + 2];
		for (int i = 0; i < arr.length; i++) {
		    for (int j = 0; j < arr[i].length; j++) {
		        Arrays.fill(arr[i][j], -1);
		    }
		}
		boolean[][][] visited = new boolean[H + 2][M + 2][N + 2];

		Queue<int[]> q = new LinkedList<>();
		for (int h = 1; h <= H; h++) {
			for (int n = 1; n <= N; n++) {
				st = new StringTokenizer(br.readLine());
				for (int m = 1; m <= M; m++) {
					arr[h][m][n] = Integer.parseInt(st.nextToken());
					if (arr[h][m][n] == 1) {
						q.add(new int[] { h, m, n, 0});
						visited[h][m][n] = true;
					}
				}
			}
		}

		int ans = 0;
		while (!q.isEmpty()) {
			int[] now = q.poll();
			ans = Math.max(ans, now[3]);
			for(int i=0;i<6;i++) {
				int th = now[0]+dir[i][0];
				int tx = now[1]+dir[i][1];
				int ty = now[2]+dir[i][2];
				
				if(arr[th][tx][ty]==0 && !visited[th][tx][ty]) {
					q.add(new int[] {th,tx,ty, now[3]+1});
					arr[th][tx][ty] = 1;
					visited[th][tx][ty] = true;
				}
			}
		}

		for(int h=1;h<=H;h++) {
			for (int m=1;m<=M;m++) {
				for(int n=1;n<=N;n++) {
					if(arr[h][m][n]==0) {
						ans = -1;
						break;
					}
				}
			}
		}
		
		System.out.println(ans);
	}
}