class Solution {
    public int[] solution(int[] sequence, int k) {
        int n = sequence.length;
        long[] sum = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + sequence[i - 1];
        }

        int l = 0, r = 0;
        int[] answer = {0, n - 1};
        boolean found = false;

        while (l <= n && r <= n) {
            long now = sum[r] - sum[l];

            if (now < k) {
                r++;
            } else if (now > k) {
                l++;
            } else {
                found = true;
                int curLen = (r - 1) - l;
                int bestLen = answer[1] - answer[0];
                if (curLen < bestLen || 
                   (curLen == bestLen && l < answer[0])) {
                    answer[0] = l;
                    answer[1] = r - 1;
                }
                l++;
            }
        }

        return answer;
    }
}
