class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] best = new int[n];

        Arrays.fill(best, Integer.MAX_VALUE);

        int temp = 0;
        int idx = 0;
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            temp += arr[i];

            while (temp > target) {
                temp -= arr[idx++];
            }

            if (i > 0) {
                best[i] = best[i - 1];
            }

            if (temp == target) {
                int len = i - idx + 1;

                if (idx > 0 && best[idx - 1] != Integer.MAX_VALUE) {
                    answer = Math.min(answer, best[idx - 1] + len);
                }

                best[i] = Math.min(best[i], len);
            }
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}