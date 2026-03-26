import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int n, m;
	static int[][] dist;
	static int[][] next;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine()); // 도시의 개수 
		m = Integer.parseInt(br.readLine()); // 버스의 개수 
		
		dist = new int[n+1][n+1]; // i->j까지의 최단 거리 
		next = new int[n+1][n+1]; // i->j 갈 때  i 다음에 가야 할 도시 번호 
		
		// dist 초기화
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				
				if(i==j) {
					dist[i][j] = 0;
				}
				else {
					dist[i][j] = Integer.MAX_VALUE;
				}
			}
		}
		
		// 버스 정보 입력받기 
		for(int i=0; i<m; i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine()); // 1 2 2
			
			int a = Integer.parseInt(st.nextToken()); // 버스의 시작 도시 
			int b = Integer.parseInt(st.nextToken()); // 버스의 도착 도시 
			int c = Integer.parseInt(st.nextToken()); // 한 번 타는데 필요한 비용 
			
			if(c < dist[a][b]) {
				dist[a][b] = c; // 기존 거리보다 더 짧으면 저장 
				next[a][b] = b; // next 초기화!! 
			}
			
		}
		
		// 플로이드 워셜
		for(int k=1; k<=n; k++) { // 중간 노드 
			for(int i=1; i<=n; i++) { // 시작 노드 
				for(int j=1; j<=n; j++) { // 도착 노드 
					
					// 아직 i->k 나 k->j 경로가 없으면 패스 
					if(dist[i][k] == Integer.MAX_VALUE || dist[k][j] == Integer.MAX_VALUE) continue;
					
					// 이 중간 노드 타고 가는 게 더 빠르면 dist 갱신
					if(dist[i][k] + dist[k][j] < dist[i][j]) {
						dist[i][j] = dist[i][k] + dist[k][j];
						next[i][j] = next[i][k]; // i->j로 갈 때의 첫 이동은 i->k갈 때의 첫 번째 이동을 따라가기 !! 
					}
					
				}
			}
		}
		
		// 비용 출력 
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(dist[i][j] == Integer.MAX_VALUE) sb.append(0).append(" ");
				else sb.append(dist[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		
		// 경로 사이즈, 경로 출력 
		for(int i=1; i<=n; i++) { // 출발 노드 
			for(int j=1; j<=n; j++) { // 도착 노드 
				
				// i->j로 갈 수 없는 경우는 0 출력하고 경로복원 패스. 언제 못 가냐? <- i==j 이거나, dist가 maxval이거나,  next가 0이거나.  
				if (i == j || dist[i][j] == Integer.MAX_VALUE || next[i][j] == 0) {
					sb.append(0).append("\n");
					continue;
				}
				
				// 갈 수 있다면 경로 출력 
				
				List<Integer> path = new ArrayList<>(); // i->j까지의 최단 경로 
				
				// 경로 복원
				int cur = i;
				
				while(cur != 0) {
					path.add(cur);
					cur = next[cur][j];
				}
				
				// i-> j 최단 경로에 포함되어 있는 도시의 개수 출력
				sb.append(path.size()).append(" ");
				
				// 경로 출력 
				for(int x : path) {
					sb.append(x).append(" ");
				}
				sb.append("\n");
			}
		}
		
		System.out.print(sb);
	}

}
