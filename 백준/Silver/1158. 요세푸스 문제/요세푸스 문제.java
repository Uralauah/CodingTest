import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            q.add(i);
        }

        System.out.print("<");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k - 1; j++) {
                q.add(q.poll());
            }
            System.out.print(q.poll());
            if (i != n - 1) {
                System.out.print(", ");
            }
        }
        System.out.print(">");
    }
}