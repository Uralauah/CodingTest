import java.io.*;
import java.util.*;

public class Main {
	public static int[] arr;
	public static int n,m;
	public static StringBuilder sb = new StringBuilder();
	public static void find(int idx, int a) {
		if(idx == m) {
			for(int num : arr) {
				sb.append(num).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=a;i<=n;i++) {
			arr[idx] = i;
			find(idx+1, i);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[m];
		find(0,1);
		
		System.out.println(sb.toString());
		
	}
}