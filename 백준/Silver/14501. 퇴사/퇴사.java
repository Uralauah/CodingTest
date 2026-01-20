import java.util.*;
import java.io.*;

class Main
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] day = new int[n];
		int[] money = new int[n];
		int[] dp = new int[n+6];
		
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			day[i] = Integer.parseInt(st.nextToken());
			money[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<n;i++) {
			dp[i+1] = Math.max(dp[i+1], dp[i]);
			
			dp[i+day[i]] = Math.max(dp[i+day[i]], dp[i]+money[i]);
		}
		
//		for(int i=0;i<=n;i++)
//			System.out.print(dp[i]+" ");
//		System.out.println();
//		
//		int ans = 0;
//		for(int i=0;i<=n;i++)
//			ans = Math.max(ans, dp[i]);
		System.out.println(dp[n]);
	}
}