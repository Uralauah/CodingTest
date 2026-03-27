import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
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
		
		N = Integer.parseInt(st.nextToken()); // 학생 수 
		M = Integer.parseInt(st.nextToken()); // 키를 비교한 횟수 
		
		graph = new ArrayList[N+1];
		indegree = new int[N+1];
		visited = new boolean[N+1];
		
		// 그래프 초기화
		for(int i=1; i<=N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			
			st = new StringTokenizer(br.readLine());
			
			int A = Integer.parseInt(st.nextToken()); // 학생 A가 학생 B의 앞에 서야 한다. 
			int B = Integer.parseInt(st.nextToken());
			
			graph[A].add(B); 
			indegree[B]++; 
		}
		
		int[] answer = new int[N]; // 위상정렬 한 결과
		int idx = 0; // answer 인덱스 
		
		// 위상정렬
		Queue<Integer> q = new ArrayDeque<>();
		
		// 시작점 처리 - indegree가 0인 것 큐에 추가 
		for(int i=1; i<=N; i++) {
			
			if(indegree[i] == 0) {
				visited[i] = true;
				q.offer(i);
				answer[idx++] = i;
			}
		}
		
		while(!q.isEmpty()) {
			
			int cur = q.poll();
			
			// 이 노드와 연결된 노드 탐색 - indegree--, indegree가 0이면 큐에 추가 
			for(int next : graph[cur]) {
				
				indegree[next]--;
				
				if(indegree[next] == 0) {
					
					if(visited[next]) continue;
					
					visited[next] = true;
					q.offer(next);
					answer[idx++] = next;
				}
			}
 		}
		
		// 위상정렬한 결과 출력
		for(int i=0; i<N; i++) {
			sb.append(answer[i]).append(" ");
		}
		
		System.out.println(sb);
	}

}
