import java.io.*;
import java.util.*;

public class Main {
	public static int[][] arr;
	public static int[] nums;
	public static char[] ops;
	public static int n;
	public static long ans = Long.MIN_VALUE;
	public static void dfs(long sum, int idx) {
		if(idx>=n/2) {
			ans = Math.max(ans, sum);
			return;
		}
		
		long temp = calc(sum, nums[idx+1], ops[idx]);
		dfs(temp,idx+1);
		
		if(idx+1<n/2) {
			temp = calc(nums[idx+1], nums[idx+2], ops[idx+1]);
			long tempSum = calc(sum, temp , ops[idx]);
			dfs(tempSum, idx+2);
		}
	}

	public static long calc(long a, long b, char op) {
		switch (op) {
		case '+':
			return a + b;
		case '*':
			return a * b;
		case '-':
			return a - b;
		}
		return -1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		String input = br.readLine();

		nums = new int[n / 2 + 1];
		ops = new char[n / 2];

		for (int i = 0; i < n; i++) {
			if (i % 2 == 0) {
				nums[i / 2] = input.charAt(i) - '0';
			} else {
				ops[i / 2] = input.charAt(i);
			}
		}
		
		dfs(nums[0],0);
		
		System.out.println(ans);
	}
}