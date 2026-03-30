import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int N, toDel, answer;
	static List<Integer>[] tree;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine()); // 트리의 노드의 개수 
		
		tree = new ArrayList[N]; // 각 노드의 자식 노드들 
		
		// 트리 초기화
		for(int i=0; i<N; i++) {
			tree[i] = new ArrayList<>();
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine()); // -1 0 0 1 1
		
		int root = -1; // 트리의 루트노드 
		
		// 트리 입력 받기 
		for(int i=0; i<N; i++) {
			int parent = Integer.parseInt(st.nextToken()); // 이 노드의 부모 번호 
			
			// 부모가 -1이면 루트노드.
			if(parent == -1) {
				root = i;
			}
			else {
				tree[parent].add(i); // 트리에 저장해주기 
			}
		}
		
		answer = 0; // 이 트리의 리프 노드의 개수 
		toDel = Integer.parseInt(br.readLine()); // 지울 노드의 번호
		
		// dfs - 이 노드의 자식  개수 세기 , 리프노드 개수 구하기 
		dfs(root);
		
		sb.append(answer);
		System.out.println(sb);
	}
	
	// 이 노드의 자식 개수 세는 함수 
	private static void dfs(int cur) {
		
		// 삭제할 노드는 무시 
		if(cur == toDel) return; 
		
		int count = 0; // 이 노드의 자식 개수 

		// 이 노드의 자식 count
		for(int next : tree[cur]) {
			
			// 자식 셀 때도 삭제할 노드는 무시 
			if(next == toDel) continue;
			
			count++; // 자식 개수 ++
			
			// 자식 개수에 대해서도 반복
			dfs(next);
		}
		
		// 자식이 없으면 리프노드다. 
		if(count == 0) {
			answer++;
		}
	}

}
