import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] in = new int[n+1];
		List<Integer>[] arr = new ArrayList[n+1];
		for(int i=1;i<=n;i++) {
			arr[i] = new ArrayList<Integer>();
		}
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			
			int k = Integer.parseInt(st.nextToken());
			
			int from = Integer.parseInt(st.nextToken());
			for(int j=1;j<k;j++) {
				int to = Integer.parseInt(st.nextToken());
				
				in[to]++;
				arr[from].add(to);
				from = to;
			}
		}
		
		Queue<Integer> q = new ArrayDeque<>();
		for(int i=1;i<=n;i++) {
			if(in[i]==0) {
				q.add(i);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		Set<Integer> s = new HashSet<>();
		while(!q.isEmpty()) {
			int now = q.poll();
			sb.append(now+"\n");
			s.add(now);
			
			for(int i=0;i<arr[now].size();i++) {
				int next = arr[now].get(i);
				in[next]--;
				
				if(in[next]==0)
					q.add(next);
			}
		}

		if(s.size()!=n) {
			System.out.println(0);
			return;
		}
		
		System.out.println(sb);
	}
}