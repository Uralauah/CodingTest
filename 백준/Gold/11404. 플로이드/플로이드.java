import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n, m;
	static int[][] dist;
	
	static class Edge {
		int from, to, weight;

		Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine()); // 도시의 개수 
		m = Integer.parseInt(br.readLine()); // 버스의 개수 
		
		dist = new int[n+1][n+1]; // 1번부터 
		
		// dist 초기화
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
		        
				// 자기 자신으로 가는 비용은 0으로 !! 
				if(i == j) {
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
			
			dist[a][b] = Math.min(dist[a][b], c); // 같은 a → b로 가는 버스가 여러 개 있을 수 있음
		}
		
		// 플로이드 워셜
		for(int k=1; k<=n; k++) { // 모든 중간 노드에 대하여 
			for(int i=1; i<=n; i++) { // 시작 노드 
				for(int j=1; j<=n; j++) { // 도착 노드 
					
					// i->k 또는 k->j 경로가 존재하지 않으면 패스 
					if(dist[i][k] == Integer.MAX_VALUE || dist[k][j] == Integer.MAX_VALUE) continue;
					
					// 이 노드 거쳐서 가는 게 더 가까우면 dist 갱신
					if(dist[i][k] + dist[k][j] < dist[i][j]) {
						dist[i][j] = dist[i][k] + dist[k][j]; // 갱신 
					}
				}
			}
		}
		
		// 출력
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {

                if (dist[i][j] == Integer.MAX_VALUE) sb.append(0).append(" ");
                else sb.append(dist[i][j]).append(" ");
            }
            sb.append("\n");
        }
		
        System.out.print(sb);
	}
}
