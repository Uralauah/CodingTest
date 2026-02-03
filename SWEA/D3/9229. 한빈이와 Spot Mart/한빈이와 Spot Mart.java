import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	public static int[] arr;
	public static int ans = -1, m;

	public static void find(int idx, int sum) {
		if (idx == 2) {
			ans = Math.max(ans, sum);
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < 0)
				continue;

			if (arr[i] + sum > m)
				continue;

			arr[i] *= -1;
			find(idx + 1, sum + (-1 * arr[i]));
			arr[i] *= -1;
		}
	}

	public static void main(String[] args) throws Exception {
		int T;
		// System.setIn(new java.io.FileInputStream("res/sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			ans = -1;
			arr = new int[n];
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<n;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			find(0,0);
			System.out.println("#" + tc + " "+ans);
		}
	}
}