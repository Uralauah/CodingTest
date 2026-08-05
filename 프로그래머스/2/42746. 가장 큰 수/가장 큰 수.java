import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] values = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            values[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(values, (a, b) -> (b + a).compareTo(a + b));
        if (values[0].equals("0")) {
            return "0";
        }

        StringBuilder result = new StringBuilder();

        for (String value : values) {
            result.append(value);
        }

        return result.toString();
    }
}