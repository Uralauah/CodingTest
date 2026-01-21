import java.io.*;
import java.util.*;

public class Main {
	public static class Node{
		int num;
		List<Node> childs;
		Node parent;
		
		public Node(int num, Node parent) {
			this.num = num;
			this.parent = parent;
			this.childs = new ArrayList<>();
		}
	}
	
	public static boolean[] visited;
	public static List<Integer>[] connect;
	public static int[] arr;
	
	public static int find(Node now) {
//		boolean flag = false;
		
		int cnt = 1;
		for(int i=0;i<connect[now.num].size();i++) {
			int next = connect[now.num].get(i);
			if(visited[next])
				continue;
//			flag = true;
			visited[next] = true;
			Node child = new Node(next, now);
			cnt+=find(child);
		}
		arr[now.num] = cnt;
		return arr[now.num];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		
		Node root = new Node(r, null);
		arr = new int[n+1];
		
		connect = new ArrayList[n+1];
		for(int i=1;i<=n;i++)
			connect[i] = new ArrayList<Integer>();
		for(int i=0;i<n-1;i++) {
			st = new StringTokenizer(br.readLine());
			int f = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			
			connect[f].add(t);
			connect[t].add(f);
		}
		visited = new boolean[n+1];
		visited[r] = true;
		
		find(root);
		
		for(int i=0;i<q;i++) {
			System.out.println(arr[Integer.parseInt(br.readLine())]);
		}
		
	}
}