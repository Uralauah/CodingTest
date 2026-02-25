import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int n, ans;
	public static int[] cols;

	public static void find(int r) {
		if (r == n) {
			ans++;
			return;
		}

		for (int i = 0; i < n; i++) {
			if (!check(r, i))
				continue;
			cols[r] = i;
			find(r + 1);
		}
	}

	public static boolean check(int r, int c) {
		for (int i = 0; i < r; i++) {
			if(cols[i] == c)
				return false;
			if (Math.abs(r - i) == Math.abs(c - cols[i]))
				return false;
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		ans = 0;
		
		cols = new int[n];
		
		find(0);
		
		System.out.println(ans);
	}
}
