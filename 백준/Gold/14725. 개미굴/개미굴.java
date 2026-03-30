import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	
	static int N;
	static StringBuilder sb;
	
	static class Node {
		Map<String, Node> child = new TreeMap<>(); // 현재 노드에서 다음으로 갈 수 있는 노드들 (사전순 정렬! -> 트리맵) 
	}
	
	static Node root = new Node(); // 루트 노드 생성 

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine()); // 로봇 개미가 각 층을 따라 내려오면서 알게 된 먹이의 정보 개수
		
		// 트리 입력 받기 
		for(int i=0; i<N; i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine()); // 2 B A
			
			int K = Integer.parseInt(st.nextToken()); // 이 로봇 개미 한마리가 보내준 먹이 정보 개수 
			
			Node cur = root; // 루트 노드에서 시작 
			
			// 트리 입력 받기 
			for(int j=0; j<K; j++) {
				
				String food = st.nextToken(); 
				
				// 이 노드가 없으면 새로 만들고, 있으면 그대로 쓰기! 
				cur.child.putIfAbsent(food, new Node());
				
				// 해당 노드로 이동 
				cur = cur.child.get(food);
			}
			
		}
		// dfs - 트리 구조 출력 
		dfs(root, 0); 
		
		System.out.println(sb);
	}
	
	// 이 노드의 자식 노드 출력  
	private static void dfs(Node cur, int depth) {
		
		// 이 노드의 자식 노드 출력
		for(String key : cur.child.keySet()) {
			// -- 출력
			for(int i=0; i<depth; i++) {
				sb.append("--");
			}
			
			sb.append(key).append("\n");
			
			// 해당 자식노드에 대해서도 반복 
			dfs(cur.child.get(key), depth+1);
		}
	}

}
