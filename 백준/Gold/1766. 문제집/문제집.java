import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static List<Integer>[] graph;
	static int[] indegree;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 문제의 수 
		M = Integer.parseInt(st.nextToken()); // 먼저 푸는 것이 좋은 문제에 대한 정보의 개수 
		
		graph = new ArrayList[N+1];
		indegree = new int[N+1]; // 각 노드로 들어오는 간선 수 
		visited = new boolean[N+1]; // 각 노드 방문 여부 
		
		// 그래프 초기화
		for(int i=1; i<=N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			
			st = new StringTokenizer(br.readLine());
			
			int A = Integer.parseInt(st.nextToken()); // A번 문제를 B번 문제보다 먼저 풀어야 함 
			int B = Integer.parseInt(st.nextToken());
			
			graph[A].add(B); // 그래프에 추가 
			indegree[B]++; // to노드에 들어오는 간선 수 ++ 
		}
		
		List<Integer> answer = new ArrayList<>(); // 위상정렬한 결과 
		
		// 위상정렬 - pq 사용. 작은 것부터 방문하고 싶으므로. 
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		// 시작점 처리 - indegree가 0인 것들 큐에 추가. 쉬운 문제부터 풀어야 하는데, 어차피 1번이 젤 쉬우니까 상관 없.
		for(int i=1; i<=N; i++) {
			
			if(indegree[i] == 0) {
				visited[i] = true;
				pq.offer(i);
			}
		}
		
		while(!pq.isEmpty()) {
			
			int cur = pq.poll();
			answer.add(cur); // 꺼내면서 결과에 저장해야 함! 
			
			// 이 노드와 연결된 노드들 탐색 - indegree--, indegree==0이면 큐에 추가, 근데 가능하면 쉬운 문제부터. 
			for(int next : graph[cur]) {
				
				indegree[next]--;
				
				if(indegree[next] == 0) {
					
					if(visited[next]) continue;
					
					// 방문 처리 
					visited[next] = true;
					pq.offer(next);
				}
			}
		}
		
		// 위상정렬 순서 출력 
		for(int x : answer) {
			sb.append(x).append(" ");
		}
		
		System.out.println(sb);
	}

}
