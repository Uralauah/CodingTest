import java.util.*;

class Solution {
    public int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    public int[][] LAND, map;
    public int[] uf;
    public int HEIGHT;
    public int max_x, max_y;

    public class Node {
        int x, y;
        public Node(int x, int y) { this.x = x; this.y = y; }
    }

    public class Bridge {
        int from, to, len;
        public Bridge(int from, int to, int len) {
            this.from = from;
            this.to = to;
            this.len = len;
        }
    }

    public boolean check(int x, int y) {
        return !(x < 0 || x >= max_x || y < 0 || y >= max_y);
    }

    public void find(int x, int y, int num) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        map[x][y] = num;

        while(!q.isEmpty()) {
            Node now = q.poll();
            for(int i = 0; i < 4; i++) {
                int tx = now.x + dir[i][0];
                int ty = now.y + dir[i][1];
                if(!check(tx, ty)) continue;
                if(map[tx][ty] != 0) continue;
                if(Math.abs(LAND[now.x][now.y] - LAND[tx][ty]) > HEIGHT) continue;
                map[tx][ty] = num;
                q.add(new Node(tx, ty));
            }
        }
    }

    public int findParent(int x) {
        if(uf[x] != x) uf[x] = findParent(uf[x]);
        return uf[x];
    }

    public void union(int x, int y) {
        int px = findParent(x);
        int py = findParent(y);
        if(px != py) uf[py] = px;
    }

    public int solution(int[][] land, int height) {
        int answer = 0;
        LAND = land;
        HEIGHT = height;
        max_x = land.length;
        max_y = land[0].length;
        map = new int[max_x][max_y];

        // 1. 영역 구분
        int num = 1;
        for(int i = 0; i < max_x; i++) {
            for(int j = 0; j < max_y; j++) {
                if(map[i][j] == 0) find(i, j, num++);
            }
        }

        // 2. 브릿지 후보 (중복 제거)
        Map<String, Integer> edgeMap = new HashMap<>();
        for(int i = 0; i < max_x; i++) {
            for(int j = 0; j < max_y; j++) {
                for(int k = 0; k < 4; k++) {
                    int tx = i + dir[k][0];
                    int ty = j + dir[k][1];
                    if(!check(tx, ty)) continue;
                    int from = map[i][j];
                    int to = map[tx][ty];
                    if(from == to) continue;
                    int cost = Math.abs(LAND[i][j] - LAND[tx][ty]);
                    if(from > to) { int tmp = from; from = to; to = tmp; }
                    String key = from + "," + to;
                    edgeMap.put(key, Math.min(edgeMap.getOrDefault(key, Integer.MAX_VALUE), cost));
                }
            }
        }

        // 3. 크루스칼 (최소 스패닝 트리)
        PriorityQueue<Bridge> pq = new PriorityQueue<>((a, b) -> a.len - b.len);
        for(Map.Entry<String, Integer> entry : edgeMap.entrySet()) {
            String[] parts = entry.getKey().split(",");
            int from = Integer.parseInt(parts[0]);
            int to = Integer.parseInt(parts[1]);
            pq.add(new Bridge(from, to, entry.getValue()));
        }

        uf = new int[num];
        for(int i = 0; i < num; i++) uf[i] = i;

        while(!pq.isEmpty()) {
            Bridge now = pq.poll();
            if(findParent(now.from) != findParent(now.to)) {
                union(now.from, now.to);
                answer += now.len;
            }
        }

        return answer;
    }
}
