import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		long[] lans = new long[k];

		long left = 1;
		long right = 0;

		for (int i = 0; i < k; i++) {
			lans[i] = Long.parseLong(br.readLine());
			right = Math.max(lans[i],right);
		}

		while (left <= right) {
			long mid = (left + right) / 2;

			int cnt = 0;
			for (int i = 0; i < k; i++) {
				cnt += lans[i] / mid;
			}

			if (cnt < n) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		
		System.out.println(left-1);
	}
}