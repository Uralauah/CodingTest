import java.util.*;

class Solution {
    public int solution(String dirs) {
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        String order = "UDLR";
        
        int x = 0, y = 0;
        Set<Long> visited = new HashSet<>();
        
        for (char c : dirs.toCharArray()) {
            int idx = order.indexOf(c);
            int nx = x + dx[idx];
            int ny = y + dy[idx];
            
            if (nx < -5 || nx > 5 || ny < -5 || ny > 5) continue;
            
            int p1 = encode(x, y);
            int p2 = encode(nx, ny);
            visited.add(edgeKey(p1, p2));
            
            x = nx;
            y = ny;
        }
        
        return visited.size();
    }
    
    private int encode(int x, int y) {
        return (x + 5) * 11 + (y + 5);
    }
    
    private long edgeKey(int a, int b) {
        long lo = Math.min(a, b);
        long hi = Math.max(a, b);
        return lo * 1000 + hi;
    }
}