import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String input = br.readLine();

            ArrayDeque<Character> left = new ArrayDeque<>();
            ArrayDeque<Character> right = new ArrayDeque<>();

            for (int i = 0; i < input.length(); i++) {
                char op = input.charAt(i);

                if (op == '<'){
                    if (!left.isEmpty())
                        right.addFirst(left.pollLast());
                }
                else if(op=='>'){
                    if(!right.isEmpty())
                        left.addLast(right.pollFirst());
                }
                else if(op=='-'){
                    if(!left.isEmpty())
                        left.pollLast();
                }
                else
                    left.addLast(op);
            }

            StringBuilder sb = new StringBuilder();
            for(char p : left)
                sb.append(p);
            for(char p : right)
                sb.append(p);

            System.out.println(sb);
        }
    }
}