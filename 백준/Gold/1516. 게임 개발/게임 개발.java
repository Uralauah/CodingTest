import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N; 
	static int[] times;
	static List<Integer>[] graph;
	static int[] indegree;
	static int[] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine()); // 건물의 종류 수 
		
		times = new int[N+1]; // 각 건물을 짓는데 걸리는 시간 
		graph = new ArrayList[N+1];
		indegree = new int[N+1]; // 각 노드로 들어노는 간선 수 (선수 과목 수)
		dp = new int[N+1]; // 각 건물이 완성되기까지 걸리는 시간 (최대 시간) 
		
		// 그래프 초기화
		for(int i=1; i<=N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		// 입력받기  
		for(int i=1; i<=N; i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int time = Integer.parseInt(st.nextToken()); // 이 건물 짓는데 걸리는 시간 
			
			times[i] = time; // 건물 짓는데 걸리는 시간 저장 
			
			while(true) {
				int pre = Integer.parseInt(st.nextToken()); // 이 건물을 짓기 위해 먼저 지어져야 하는 건물들의 번호 
				
				if (pre == -1) break;
				
				graph[pre].add(i); // 그래프에 저장 
				indegree[i]++; // 선수과목 수 ++ 
			}
		}
		
		// 위상정렬 
		Queue<Integer> q = new ArrayDeque<>();
		
		// 시작점 처리 (선수과목 수가 0인 것 추가해주기)
		for(int i=1; i<=N; i++) {
			
			if(indegree[i] == 0) {
				dp[i] = times[i]; // 이 건물 짓는데 걸리는 시간 저장  
				q.offer(i); // 큐에 추가 
			}
		}
		
		int answer = 0; // 모든 건물들이 완성되기까지 걸리는 최소 시간 
		
		while(!q.isEmpty()) {
			
			// 큐에서 하나 꺼내기 (이 건물 지음) 
			int cur = q.poll(); 
			
			// 이 노드와 연결된 노드 중 선수과목이 0인 것 큐에 추가
			for(int next : graph[cur]) {
				
				indegree[next]--; // 선수과목 수 하나 줄여주기 
				
				// 이 건물이 완성되기까지 걸리는 시간이 더 길게 걸린다면 갱신. (최댓값 갱신)
				if(dp[cur] + times[next] > dp[next]) {
					dp[next] = dp[cur] + times[next]; // 갱신
				}
				
				// 선수과목 남은 거 없으면 큐에 추가 
				if(indegree[next] == 0) {
					q.offer(next); // 큐에 추가 
				}
			}
		}
		
		for(int i=1; i<=N; i++) {
			sb.append(dp[i]).append("\n");
		}
		
		System.out.println(sb);
	}

}
