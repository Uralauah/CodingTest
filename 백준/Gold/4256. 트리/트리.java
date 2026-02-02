import java.io.*;
import java.util.*;

public class Main {
	public static int[] pre;
	public static int n, preIndex;
	public static StringBuilder sb;
	public static Map<Integer, Integer> in;

	public static void find(int si, int ei) {
		if (si > ei)
			return;

		int rootVal = pre[preIndex++];
		int rootIdx = in.get(rootVal);

		find(si, rootIdx - 1);
		find(rootIdx + 1, ei);

		sb.append(rootVal).append(" ");
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			in = new HashMap<>();
			preIndex = 0;
			n = Integer.parseInt(br.readLine());

			pre = new int[n];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				pre[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				in.put(Integer.parseInt(st.nextToken()), i);
			}

			sb = new StringBuilder();
			find(0, n - 1);
			System.out.println(sb.toString());
		}
	}
}