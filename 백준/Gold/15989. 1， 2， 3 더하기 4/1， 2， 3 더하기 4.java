import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			
			int[] dp = new int[n+1];
			
			for(int i=1;i<=(n<3?n:3);i++) {
				dp[i]=i;
			}
			for(int i=4;i<=n;i++) {
				dp[i] = dp[i-3] + i/2 +1;
			}
			
			System.out.println(dp[n]);
		}
	}
}
