import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int ans = 0;
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            Set<Character> s = new HashSet<>();

            s.add(input.charAt(0));

            boolean flag = false;
            for(int j=1;j<input.length();j++){
                if(s.contains(input.charAt(j)) && input.charAt(j-1)!=input.charAt(j)){
                    flag = true;
                    break;
                }
                s.add(input.charAt(j));
            }

            if (!flag) {
                ans++;
            }
        }

        System.out.println(ans);

    }
}