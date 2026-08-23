import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        Deque<int[]> q = new ArrayDeque<>();
        boolean[] visited = new boolean[y + 1];

        q.add(new int[]{x, 0});
        visited[x] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            int value = now[0];
            int count = now[1];

            if (value == y) {
                return count;
            }

            int[] next = {
                value + n,
                value * 2,
                value * 3
            };

            for (int nextValue : next) {
                if (nextValue > y) {
                    continue;
                }
                if (visited[nextValue]) {
                    continue;
                }

                visited[nextValue] = true;
                q.add(new int[]{nextValue, count + 1});
            }
        }

        return -1;
    }
}