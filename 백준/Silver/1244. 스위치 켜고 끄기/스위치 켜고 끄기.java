import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		int[] leds = new int[n];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<n;i++) {
			leds[i] = st.nextToken().charAt(0)-'0';
		}
		
		int s = Integer.parseInt(br.readLine());
		
		for(int t=0;t<s;t++) {
			st = new StringTokenizer(br.readLine());
			
			int sex = st.nextToken().charAt(0)-'0';
			int cnt = Integer.parseInt(st.nextToken());
			
			switch(sex) {
			case 1:
				for(int i=cnt-1;i<n;i+=cnt) {
					leds[i] = (leds[i]+1)%2;
				}
				break;
			case 2:
				int len = Math.min(cnt-1, n-cnt);
				leds[cnt-1] = (leds[cnt-1]+1)%2;
				for(int i=1;i<=len;i++) {
					if(leds[cnt-1-i]!=leds[cnt-1+i])
						break;
					leds[cnt-1-i] = (leds[cnt-1-i]+1)%2;
					leds[cnt-1+i] = leds[cnt-1-i];
				}
				break;
			}
		}
		
		for (int i = 0; i < n; i++) {
            if (i % 20 == 0 && i != 0) System.out.println();
            System.out.print(leds[i] + " ");
        }
	}
}
