import java.util.*;

class Solution {
    private boolean isValid(Map<String, Integer> target, Map<String, Integer> window) {
        for (String key : target.keySet()) {
            if (!target.get(key).equals(window.getOrDefault(key, 0))) {
                return false;
            }
        }

        return true;
    }
    
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        Map<String, Integer> target = new HashMap<>();
        Map<String, Integer> window = new HashMap<>();

        for (int i = 0; i < want.length; i++) {
            target.put(want[i], number[i]);
        }

        for (int i = 0; i < 10; i++) {
            window.put(discount[i], window.getOrDefault(discount[i], 0) + 1);
        }

        if (isValid(target, window)) {
            answer++;
        }

        for (int i = 10; i < discount.length; i++) {
            String remove = discount[i - 10];
            String add = discount[i];

            window.put(remove, window.get(remove) - 1);

            if (window.get(remove) == 0) {
                window.remove(remove);
            }

            window.put(add, window.getOrDefault(add, 0) + 1);

            if (isValid(target, window)) {
                answer++;
            }
        }

        return answer;
    }
}