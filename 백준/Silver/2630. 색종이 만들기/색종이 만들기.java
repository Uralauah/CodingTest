import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int[][] arr;
	public static int n;
	public static int w, b;

	public static void check(int ru, int rd, int cl, int cr) {
		int now = arr[ru][cl];

		for (int i = ru; i <= rd; i++) {
			for (int j = cl; j <= cr; j++) {
				if (arr[i][j] != now) {
					check(ru, (ru + rd) / 2, cl, (cl + cr) / 2);
					check(ru, (ru + rd) / 2, (cl + cr) / 2 + 1, cr);
					check((ru + rd) / 2 + 1, rd, cl, (cl + cr) / 2);
					check((ru + rd) / 2 + 1, rd, (cl + cr) / 2 + 1, cr);
					return;
				}
			}
		}
		if (now == 0)
			w++;
		else {
			b++;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = st.nextToken().charAt(0) - '0';
			}
		}

		check(0, n - 1, 0, n - 1);
		
		System.out.println(w);
		System.out.println(b);
	}
}
