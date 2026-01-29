import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			String[] input = new String[n];
			for (int i = 0; i < n; i++) {
				input[i] = sc.next();
			}

			String[] output = new String[n];

			int mid = (n % 2 == 0 ? n / 2 : n / 2 + 1);
			for (int i = 0; i < mid; i++) {
				output[i * 2] = input[i];
			}
			for(int i=mid;i<n;i++) {
				output[i%mid*2+1] = input[i];
			}
			
			System.out.print("#"+test_case+" ");
			for(int i=0;i<n;i++) {
				System.out.print(output[i]+" ");
			}
			System.out.println();
		}
	}
}