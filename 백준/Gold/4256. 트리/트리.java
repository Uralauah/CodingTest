import java.io.*;
import java.util.*;

public class Main {
	public static int[] pre, in;
	public static int n;
	public static StringBuilder sb;

	public static class Node {
		int num;
		Node left;
		Node right;

		public Node(int num) {
			this.num = num;
		}
	}

	public static Node find(int si, int ei) {
		if (si >= ei) {
			return null;
		}
		Map<Integer, Integer> s = new HashMap<>();
		for (int i = si; i < ei; i++) {
			s.put(in[i], i);
		}

		int p = -1;
		for (int i = 0; i < n; i++) {
			if (s.containsKey(pre[i])) {
				p = pre[i];
				break;
			}
		}
		Node root = new Node(p);

		root.left = find(si, s.get(p));
		root.right = find(s.get(p) + 1, ei);
		return root;
	}
	
	public static void post(Node root) {
		if(root.left!=null) {
			post(root.left);
		}
		if(root.right!=null) {
			post(root.right);
		}
		sb.append(root.num).append(" ");
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			n = Integer.parseInt(br.readLine());

			pre = new int[n];
			in = new int[n];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				pre[i] = Integer.parseInt(st.nextToken());
			}

			int mid = -1;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				in[i] = Integer.parseInt(st.nextToken());
				if (in[i] == pre[0]) {
					mid = i;
				}
			}

			Node root = find(0,n);
			sb = new StringBuilder();
			post(root);
			System.out.println(sb.toString());
		}
	}
}