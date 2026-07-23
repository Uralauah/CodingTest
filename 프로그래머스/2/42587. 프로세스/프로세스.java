import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Deque<int[]> q = new ArrayDeque<>();

        for (int i = 0; i < priorities.length; i++) {
            q.offerLast(new int[]{priorities[i], i});
        }

        int order = 0;

        while (!q.isEmpty()) {
            int[] current = q.pollFirst();
            boolean hasHigher = false;

            for (int[] process : q) {
                if (process[0] > current[0]) {
                    hasHigher = true;
                    break;
                }
            }

            if (hasHigher) {
                q.offerLast(current);
            } else {
                order++;

                if (current[1] == location) {
                    return order;
                }
            }
        }

        return -1;
    }
}