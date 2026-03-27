import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.concurrent.CountDownLatch;

public class Main {
	
	static int n, m;
	static List<Edge>[] graph;
	static int[] indegree;
	static int[] dp;
	static List<Edge>[] reverseGraph;
	static boolean[] visited;
	static int count;
	
	static class Edge {
		int to, weight;

		Edge(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine()); // 도시의 개수
		m = Integer.parseInt(br.readLine()); // 도로의 개수
		
		graph = new ArrayList[n+1];
		indegree = new int[n+1]; // 각 노드로 들어오는 간선 수
		dp = new int[n+1]; // 출발지에서 각 노드까지의 최장 거리 
		reverseGraph = new ArrayList[n+1];
		visited = new boolean[n+1];
		
		// 그래프 초기화
		for(int i=1; i<=n; i++) {
			graph[i] = new ArrayList<>();
			reverseGraph[i] = new ArrayList<>();
		}
		
		// 간선 정보 입력받기 (도로의 정보) 
		for(int i=0; i<m; i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken()); // 도시 u에서 v로 향하는 일방통행 도로 
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken()); // 이 도로 지나는데 걸리는 시간 
			
			graph[u].add(new Edge(v, w)); // 그래프에 저장 
			reverseGraph[v].add(new Edge(u, w)); // 역방향 그래프에 저장 
			indegree[v]++; // to노드에 들어오는 간선 수 증가시켜주기  
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int start = Integer.parseInt(st.nextToken()); 
		int end = Integer.parseInt(st.nextToken());
		
		// 위상정렬 
		Queue<Integer> q = new ArrayDeque<>();
		
		// 시작점 처리 - 큐에 추가, 최장거리 0 
		dp[start] = 0;
		q.offer(start);
		
		while(!q.isEmpty()) {
			
			// 큐에서 하나 꺼내기 
			int cur = q.poll();
			
			// 이 노드랑 연결된 노드 탐색 - indegree--, dp 업데이트, indegree 0인 거 큐에 추가 
			for(Edge next : graph[cur]) {
				
				int nextNode = next.to;
				int nextWeight = next.weight; 
				
				indegree[nextNode]--;
				
				// 이 간선을 통해 가는 게 더 길면, 최장경로 갱신 
				if(dp[cur] + nextWeight > dp[nextNode]) {
					dp[nextNode] = dp[cur] + nextWeight; // 갱신 
				}
				
				if(indegree[nextNode] == 0) {
					q.offer(nextNode);
				}
			}
		}
		
		count = 0; // 최장경로에 속한 간선 수 
		
		// 최장경로에 속한 간선들의 개수 구하기 (최장 경로가 여러 개일 수 있고, 사용한 간선이 겹칠 수도 있음)
		bfs(end); 
		
		sb.append(dp[end]).append("\n");
		sb.append(count);
		
		System.out.println(sb);
	}
	
	// 역방향 bfs - 해당 간선이 최장경로에 속한 간선이지 세는 함수 
	private static void bfs(int start) {
		
		Queue<Integer> q2 = new ArrayDeque<>();
		
		// 시작점 처리 
		visited[start] = true;
		q2.offer(start);
		
		while(!q2.isEmpty()) {
			
			// 하나 꺼내기 
			int cur = q2.poll();
			
			// 이와 연결된 간선 탐색 - 해당 간선이 최장경로에 속한 간선이지 체크
			for(Edge e : reverseGraph[cur]) {
				
				int nextNode = e.to; // 이 간선과 연결된 노드 
				int nextWeight = e.weight; // 이 간선의 가중치 
				
				// 이 간선이 최장경로에 속한 간선이면 count++
				if(dp[nextNode] + nextWeight == dp[cur]) {
					count++; // 최장경로에 속한 간선 수 ++
					
					if(visited[nextNode]) continue;
					
					// 간선 세고 나서, 노드 방문 처리!! 
					visited[nextNode] = true;
					q2.offer(nextNode);
				}
			}
		}
	}
}
