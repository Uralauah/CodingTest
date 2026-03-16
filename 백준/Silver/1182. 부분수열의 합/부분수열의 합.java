import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int[] arr;
	public static int ans;
	public static int s, n;

	public static void find(int idx, int sum, int cnt, int max) {
		if (cnt == max) {
			if (s == sum) {
				ans++;
			}
			return;
		}

		if (idx >= n)
			return;

		find(idx + 1, sum + arr[idx], cnt + 1, max);
		find(idx + 1, sum, cnt, max);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		ans = 0;
		for (int i = 1; i <= n; i++) {
			find(0, 0, 0, i);
		}
		
		System.out.println(ans);
	}
}