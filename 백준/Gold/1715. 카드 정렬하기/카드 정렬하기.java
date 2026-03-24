import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int i=0;i<n;i++) {
			int input = Integer.parseInt(br.readLine());
			
			pq.add(input);
		}
		
		int ans = 0;
		while(pq.size()!=1) {
			int num1 = pq.poll();
			int num2 = pq.poll();
			ans += num1 + num2;
			pq.add(num1 + num2);
		}
		
		System.out.println(ans);
	}
}
