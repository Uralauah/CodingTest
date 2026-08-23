class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        int[] rightCount = new int[10001];
        boolean[] leftHas = new boolean[10001];

        int rightKinds = 0;
        int leftKinds = 0;

        for (int t : topping) {
            if (rightCount[t] == 0) {
                rightKinds++;
            }
            rightCount[t]++;
        }

        for (int i = 0; i < topping.length - 1; i++) {
            int t = topping[i];

            if (!leftHas[t]) {
                leftHas[t] = true;
                leftKinds++;
            }

            rightCount[t]--;

            if (rightCount[t] == 0) {
                rightKinds--;
            }
            if (leftKinds == rightKinds) {
                answer++;
            }
        }

        return answer;
    }
}