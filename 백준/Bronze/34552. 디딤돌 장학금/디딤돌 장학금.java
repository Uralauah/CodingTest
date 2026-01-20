import java.util.*;
import java.io.*;

class Main
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[11];
		
		for(int i=0;i<=10;i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		int n = Integer.parseInt(br.readLine());
		
		int ans = 0;
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int b = Integer.parseInt(st.nextToken());
			double s = Double.parseDouble(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			
			if(s<2.0 || a <17)
				continue;
			ans += arr[b];
		}
		
		System.out.println(ans);
	}
}