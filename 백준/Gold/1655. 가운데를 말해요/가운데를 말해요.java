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
		
		int n = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			int input = Integer.parseInt(br.readLine());
			
			if(min.size() == max.size()) {
				if(!min.isEmpty() && min.peek() < input) {
					max.add(min.poll());
					min.add(input);
				}
				else
					max.add(input);
			}
			else {
				if(!max.isEmpty() && max.peek() > input) {
					min.add(max.poll());
					max.add(input);
				}
				else
					min.add(input);
			}
			
			sb.append(max.peek()).append("\n");
		}
		
		System.out.println(sb);
	}
}
