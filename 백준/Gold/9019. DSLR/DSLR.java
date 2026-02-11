import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static class Data {
		int num;
		String op;

		public Data(int num, String op) {
			this.num = num;
			this.op = op;
		}
	}

	public static Data cal(int num, String op, int opIdx) {
		Data data = new Data(num, op);
		switch (opIdx) {
		case 0:
			data.num = (data.num * 2) % 10000;
			data.op += "D";
			break;
		case 1:
			data.num = data.num - 1 == -1 ? 9999 : data.num - 1;
			data.op += "S";
			break;
		case 2:
			data.num = (data.num * 10) % 10000 + data.num / 1000;
			data.op += "L";
			break;
		case 3:
			data.num = data.num / 10 + data.num % 10 * 1000;
			data.op += "R";
			break;
		}
		return data;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for (int t = 0; t < T; t++) {
			boolean[] visited = new boolean[10000];
			Queue<Data> q = new ArrayDeque<>();
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			q.add(new Data(A, ""));
			boolean flag = false;

			while (!q.isEmpty()) {
				Data data = q.poll();
				if (flag)
					break;

				for (int i = 0; i < 4; i++) {
					Data newData = cal(data.num, data.op, i);
					if (newData.num == B) {
						System.out.println(newData.op);
						flag = true;
						break;
					}
					if(visited[newData.num])
						continue;
					q.add(newData);
					visited[newData.num] = true;
				}
			}
		}
	}
}
