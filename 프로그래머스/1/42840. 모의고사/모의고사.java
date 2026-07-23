import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[][] patterns = {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };

        int[] scores = new int[3];

        for (int i = 0; i < answers.length; i++) {
            for (int person = 0; person < patterns.length; person++) {
                int[] pattern = patterns[person];

                if (answers[i] == pattern[i % pattern.length]) {
                    scores[person]++;
                }
            }
        }

        int maxScore = Math.max(
            scores[0],
            Math.max(scores[1], scores[2])
        );

        List<Integer> result = new ArrayList<>();

        for (int person = 0; person < scores.length; person++) {
            if (scores[person] == maxScore) {
                result.add(person + 1);
            }
        }

        int[] answer = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}