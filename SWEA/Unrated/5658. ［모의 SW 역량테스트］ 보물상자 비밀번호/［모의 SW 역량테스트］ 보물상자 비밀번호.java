import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int TC = Integer.parseInt(st.nextToken());

		for (int testcase = 1; testcase <= TC; ++testcase) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			Set<Integer> s = new HashSet<>();
			String input = br.readLine();
			input = input + input;

			int len = n / 4;
			for (int i = 0; i < len; i++) {
				s.add(Integer.parseInt(input.substring(i, i + len), 16));
				s.add(Integer.parseInt(input.substring(i + len, i + len + len),16));
				s.add(Integer.parseInt(input.substring(i + len + len, i + len + len + len),16));
				s.add(Integer.parseInt(input.substring(i + len + len + len, i + len + len + len + len),16));
			}

			Integer[] result = s.toArray(new Integer[0]);
			Arrays.sort(result , Collections.reverseOrder());

			System.out.println("#" + testcase + " " + result[k - 1]);
		}

		br.close();
	}
}
