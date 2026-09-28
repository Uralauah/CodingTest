import java.util.*;

class Solution {
    public int minReorder(int n, int[][] connections) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int[] c : connections) {
            graph.get(c[0]).add(new int[]{c[1], 1});
            graph.get(c[1]).add(new int[]{c[0], 0});
        }

        boolean[] visited = new boolean[n];
        Deque<Integer> q = new ArrayDeque<>();
        q.add(0);
        visited[0] = true;
        int ans = 0;

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int[] next : graph.get(now)) {
                int node = next[0];
                if (visited[node]) continue;
                visited[node] = true;
                ans += next[1];
                q.add(node);
            }
        }

        return ans;
    }
}