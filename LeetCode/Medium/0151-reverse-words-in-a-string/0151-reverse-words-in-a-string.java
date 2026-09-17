import java.util.*;

class Solution {
    public String reverseWords(String s) {
        Deque<String> stack = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(s);

        StringBuilder sb = new StringBuilder();

        while(st.hasMoreTokens()){
            stack.addLast(st.nextToken());
        }

        while(!stack.isEmpty()){
            sb.append(stack.pollLast());
            if(!stack.isEmpty())
                sb.append(" ");
        }

        return sb.toString();
    }
}