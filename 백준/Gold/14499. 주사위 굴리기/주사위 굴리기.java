import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[][] dir = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dice = new int[6]; //위, 아래, 북, 남, 동, 서

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            int now = Integer.parseInt(st.nextToken());

            int tx = x + dir[now - 1][0];
            int ty = y + dir[now - 1][1];

            if (tx < 0 || tx >= n || ty < 0 || ty >= m)
                continue;

            x = tx;
            y = ty;

            int temp;
            switch (now){
                case 1:
                    temp = dice[0];
                    dice[0] = dice[5];
                    dice[5] = dice[1];
                    dice[1] = dice[4];
                    dice[4] = temp;
                    break;
                case 2:
                    temp = dice[0];
                    dice[0] = dice[4];
                    dice[4] = dice[1];
                    dice[1] = dice[5];
                    dice[5] = temp;
                    break;
                case 3:
                    temp = dice[0];
                    dice[0] = dice[3];
                    dice[3] = dice[1];
                    dice[1] = dice[2];
                    dice[2] = temp;
                    break;
                case 4:
                    temp = dice[0];
                    dice[0] = dice[2];
                    dice[2] = dice[1];
                    dice[1] = dice[3];
                    dice[3] = temp;
                    break;
            }

            if(map[x][y]==0){
                map[x][y] = dice[1];
            }else{
                dice[1] = map[x][y];
                map[x][y] = 0;
            }

            System.out.println(dice[0]);
        }
    }
}