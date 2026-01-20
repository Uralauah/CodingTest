import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
		
		int c = Integer.parseInt(stringTokenizer.nextToken());
		int n = Integer.parseInt(stringTokenizer.nextToken());
		
		int[] money = new int[n];
		int[] people = new int[n];
		
		for(int i=0;i<n;i++) {
			stringTokenizer = new StringTokenizer(br.readLine());
			money[i] = Integer.parseInt(stringTokenizer.nextToken());
			people[i] = Integer.parseInt(stringTokenizer.nextToken());
		}
		
		int[] dp = new int[c+101];
		Arrays.fill(dp, 10000000);
		dp[0] = 0;
		
		for(int i=0;i<c;i++) {
			for(int j=0;j<n;j++) {
				dp[i+people[j]] = Math.min(dp[i] + money[j], dp[i+people[j]]);
			}
		}
		
		int ans = Integer.MAX_VALUE;
		for(int i=c;i<dp.length;i++) {
			ans = Math.min(ans, dp[i]);
		}
		System.out.println(ans);
	}
}
