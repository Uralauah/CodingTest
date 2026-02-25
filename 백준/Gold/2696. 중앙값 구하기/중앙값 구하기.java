import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		PriorityQueue<Integer> min = new PriorityQueue<>();
		PriorityQueue<Integer> max = new PriorityQueue<>((o1, o2) -> {
			return o2 - o1;
		});

		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			min.clear();
			max.clear();
			int m = Integer.parseInt(br.readLine());
			int r = m / 10 + 1;
			sb.append(m / 2 + 1).append("\n");
			int cnt = 0;
			for (int i = 0; i < r; i++) {
				st = new StringTokenizer(br.readLine());

				while (st.hasMoreTokens()) {
					int input = Integer.parseInt(st.nextToken());

					if (max.size() == min.size())
						max.add(input);
					else
						min.add(input);

					if (!min.isEmpty() && max.peek() > min.peek()) {
						int t1 = max.poll();
						int t2 = min.poll();
						max.add(t2);
						min.add(t1);
					}

					if (max.size() != min.size()) {
						cnt++;
						sb.append(max.peek()).append(" ");
						if (cnt % 10 == 0)
							sb.append("\n");
						
					}
				}
			}
			if(cnt%10!=0)
				sb.append("\n");
		}
		System.out.println(sb);
	}
}
