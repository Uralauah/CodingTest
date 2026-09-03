import java.util.*;
import java.util.stream.*;

class Solution {
    private static class FileName {
        final String original;
        final String head;
        final int number;

        FileName(String original, String head, int number) {
            this.original = original;
            this.head = head;
            this.number = number;
        }
    }

    public String[] solution(String[] files) {
        FileName[] parsed = new FileName[files.length];
        for (int i = 0; i < files.length; i++) {
            parsed[i] = parse(files[i]);
        }

        Arrays.sort(parsed, (a, b) -> {
            int headCompare = a.head.compareTo(b.head);
            if (headCompare != 0) return headCompare;
            return Integer.compare(a.number, b.number);
        });

        String[] answer = new String[parsed.length];
        for (int i = 0; i < parsed.length; i++) {
            answer[i] = parsed[i].original;
        }
        return answer;
    }

    private FileName parse(String file) {
        int headEnd = findNumStart(file);
        int numberEnd = findNumEnd(file, headEnd);

        String head = file.substring(0, headEnd).toLowerCase();
        int number = Integer.parseInt(file.substring(headEnd, numberEnd));

        return new FileName(file, head, number);
    }

    private int findNumStart(String s) {
        int i = 0;
        while (i < s.length() && !Character.isDigit(s.charAt(i))) i++;
        return i;
    }

    private int findNumEnd(String s, int start) {
        int i = start;
        while (i < s.length() && Character.isDigit(s.charAt(i)) && i - start < 5) i++;
        return i;
    }
}