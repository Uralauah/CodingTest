import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());

		for (int testcase = 1; testcase <= TC; ++testcase) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());

			int[][] dir = { { 0, 0 }, { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

			int[][] move = new int[2][m + 1];

			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= m; j++) {
					move[i][j] = st.nextToken().charAt(0) - '0';
				}
			}

			int[][] ap = new int[a][4];

			for (int i = 0; i < a; i++) {
				st = new StringTokenizer(br.readLine());
				ap[i][1] = Integer.parseInt(st.nextToken());
				ap[i][0] = Integer.parseInt(st.nextToken());
				ap[i][2] = Integer.parseInt(st.nextToken());
				ap[i][3] = Integer.parseInt(st.nextToken());
			}

			int ax = 1;
			int ay = 1;
			int bx = 10;
			int by = 10;

			int ans = 0;
			List<Integer> listA = new ArrayList<>();
			List<Integer> listB = new ArrayList<>();

			for (int i = 0; i <= m; i++) {
				ax += dir[move[0][i]][0];
				ay += dir[move[0][i]][1];

				bx += dir[move[1][i]][0];
				by += dir[move[1][i]][1];

				listA.clear();
				listB.clear();
				listA.add(-1);
				listB.add(-1);

				for (int j = 0; j < a; j++) {
					int distA = Math.abs(ax - ap[j][0]) + Math.abs(ay - ap[j][1]);
					int distB = Math.abs(bx - ap[j][0]) + Math.abs(by - ap[j][1]);

					if (distA <= ap[j][2])
						listA.add(j);
					if (distB <= ap[j][2])
						listB.add(j);
				}
				
				int maxCharge = 0;
				for(int ta : listA) {
					for(int tb : listB) {
						if(ta==-1 && tb==-1) {
							continue;
						}
						else if(ta==-1) {
							maxCharge = Math.max(maxCharge, ap[tb][3]);
						}
						else if(tb == -1) {
							maxCharge = Math.max(maxCharge, ap[ta][3]);
						}
						else if(ta==tb) {
							maxCharge = Math.max(maxCharge, ap[ta][3]);
						}
						else {
							maxCharge = Math.max(maxCharge, ap[ta][3] + ap[tb][3]);
						}
					}
				}
				
				ans+=maxCharge;
			}

			System.out.println("#" + testcase + " " + ans);
		}

	}
}