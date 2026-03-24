import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
			if(Math.abs(o1)== Math.abs(o2))
				return o1 - o2;
			return Math.abs(o1) - Math.abs(o2);
		});
		
		for(int i=0;i<n;i++) {
			int input = Integer.parseInt(br.readLine());
			
			if(input==0) {
				if(pq.isEmpty())
					System.out.println(0);
				else
					System.out.println(pq.poll());
				continue;
			}
			
			pq.add(input);
		}
	}
}
