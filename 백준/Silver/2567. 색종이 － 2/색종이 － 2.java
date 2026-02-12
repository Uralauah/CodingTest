import java.io.*;
import java.util.*;

public class Main {
	public static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[101][101];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			
			int l = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			for(int j=l;j<l+10;j++) {
				for(int k=d;k<d+10;k++) {
					arr[j][k] = 1;
				}
			}
		}
		
		int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
		
		int len = 0;
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				if(arr[i][j]==1) {
					for(int d=0;d<4;d++) {
						int tx = i+dir[d][0];
						int ty = j+dir[d][1];
						
						if(arr[tx][ty]==0) {
							len++;
						}
					}
				}
			}
		}
		
		
//		for(int i=0;i<100;i++) {
//			for(int j=0;j<100;j++) {
//				System.out.print(arr[i][j]+" ");
//			}
//			System.out.println();
//		}
//		
		System.out.println(len);
	}
}