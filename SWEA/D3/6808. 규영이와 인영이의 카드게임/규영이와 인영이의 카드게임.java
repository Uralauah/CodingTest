import java.util.Scanner;

class Solution {
	static int[] in;
	static int[] gyu;
	static boolean[] visited = new boolean[9];

	static int iw, gw;

	public static void find(int idx, int is, int gs) {
		if (idx == 9) {
			if (is > gs) {
				iw++;
			} else if (is < gs) {
				gw++;
			}
			return;
		}

		for (int i = 0; i < 9; i++) {
			if (!visited[i]) {
				visited[i] = true;
				if (gyu[idx] > in[i])
					find(idx + 1, is, gs + gyu[idx] + in[i]);
				else if (gyu[idx] < in[i])
					find(idx + 1, is + gyu[idx] + in[i], gs);
				visited[i] = false;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();

		for (int testcase = 1; testcase <= TC; ++testcase) {
			in = new int[9];
			gyu = new int[9];
			gw = 0;
			iw = 0;

			boolean[] num = new boolean[19];

			for (int i = 0; i < 9; i++) {
				gyu[i] = sc.nextInt();
				num[gyu[i]] = true;
			}

			int idx = 0;
			for (int i = 1; i <= 18; i++) {
				if (!num[i]) {
					in[idx++] = i;
				}
			}
			find(0, 0, 0);

			System.out.println("#" + testcase + " " + gw + " " + iw);
		}

		sc.close();
	}
}