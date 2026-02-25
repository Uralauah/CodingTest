import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		int[] items = new int[n];
		int[][] road = new int[n][n];
		
		for(int i=0;i<n;i++) {
			Arrays.fill(road[i], 10000000);
			road[i][i] = 0;
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			items[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<r;i++) {
			st = new StringTokenizer(br.readLine());
			int f = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			road[f-1][t-1] = d;
			road[t-1][f-1] = d;
		}
		
		for(int k=0;k<n;k++) {
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					road[i][j] = Math.min(road[i][j], road[i][k] + road[k][j]);
				}
			}
		}
		
		int ans = 0;
		for(int i=0;i<n;i++) {
			int sum = 0;
			for(int j=0;j<n;j++) {
				if(road[i][j] <= m) {
					sum+=items[j];
				}
			}
			ans = Math.max(sum, ans);
		}
		
		System.out.println(ans);
	}
}

