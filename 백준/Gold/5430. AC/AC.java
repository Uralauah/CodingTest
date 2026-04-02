import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            String p = br.readLine();

            int n = Integer.parseInt(br.readLine());

            String input = br.readLine();
            input = input.substring(1, input.length()-1);

            Deque<Integer> array = new ArrayDeque<>();
            StringTokenizer st = new StringTokenizer(input, ",");

            while (st.hasMoreTokens()) {
                array.addLast(Integer.parseInt(st.nextToken()));
            }

            boolean head = true;
            boolean error = false;
            for (int i = 0; i < p.length(); i++) {
                char op = p.charAt(i);

                if (op == 'R') {
                    head = !head;
                    continue;
                }

                if (array.isEmpty()) {
                    error = true;
                    break;
                }

                if (head) array.pollFirst();
                else array.pollLast();
            }
            if(error){
                sb.append("error").append("\n");
            }
            else{
                sb.append("[");
                while (!array.isEmpty()) {
                    if(head)
                        sb.append(array.pollFirst());
                    else
                        sb.append(array.pollLast());

                    if(!array.isEmpty())
                        sb.append(",");
                }
                sb.append("]").append("\n");
            }
        }

        System.out.print(sb);
    }
}