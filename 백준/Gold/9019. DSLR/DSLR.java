import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int[] parent;
	public static char[] how;
	public static char[] operation = { 'D', 'S', 'L', 'R' };

	public static int cal(int num, int opIdx) {
		switch (opIdx) {
		case 0:
			num = (num * 2) % 10000;
			break;
		case 1:
			num = num - 1 == -1 ? 9999 : num - 1;
			break;
		case 2:
			num = (num * 10) % 10000 + num / 1000;
			break;
		case 3:
			num = num / 10 + num % 10 * 1000;
			break;
		}
		return num;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		for (int t = 0; t < T; t++) {
			boolean[] visited = new boolean[10000];
			parent = new int[10000];
			how = new char[10000];

			Queue<Integer> q = new ArrayDeque<>();
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			q.add(A);
			visited[A] = true;
			while (!q.isEmpty()) {
				Integer num = q.poll();

				if (num == B)
					break;

				for (int i = 0; i < 4; i++) {
					int newNum = cal(num, i);

					if (visited[newNum])
						continue;
					q.add(newNum);
					visited[newNum] = true;
					parent[newNum] = num;
					how[newNum] = operation[i];
					
					if(newNum==B) {
						q.clear();
						break;
					}
				}
			}

			int temp = B;
			StringBuilder buff = new StringBuilder();
			while (temp != A) {
				buff.append(how[temp]);
				temp = parent[temp];
			}
			sb.append(buff.reverse()).append("\n");
		}
		System.out.println(sb);
	}
}