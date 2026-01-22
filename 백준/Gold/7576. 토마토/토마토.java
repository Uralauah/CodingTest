import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

		int[][] arr = new int[N + 2][M + 2];
		for(int i=0;i<=N+1;i++)
			Arrays.fill(arr[i],-1);
		
		
		Queue<int[]> q = new LinkedList<>();
		int ans = 0;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1) {
					q.add(new int[] { i, j, 0 });
				}
			}
		}
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			ans = Math.max(ans, now[2]);
			for(int i=0;i<4;i++) {
				int tx = now[0] + dir[i][0];
				int ty = now[1] + dir[i][1];
				
				if(arr[tx][ty]==0) {
					q.add(new int[] {tx,ty,now[2]+1});
					arr[tx][ty] = 1;
				}
			}
		}
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=M;j++) {
				if(arr[i][j]==0) {
					ans=-1;
					break;
				}
			}
		}
		System.out.println(ans);
	}
}