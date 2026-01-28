import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String S = br.readLine();
		String P = br.readLine();
		
		int si = 0;
		int ans = 0;
		
		while(si<P.length()) {
			int maxLen = 0;
			for(int i = si+1;i<=P.length();i++) {
				if(S.indexOf(P.substring(si,i)) == -1) {
//					System.out.println(si+" "+i);
//					System.out.println(P.substring(si,i-1));
					break;
				}
				maxLen++;
			}
			si = si+maxLen;
			ans++;
		}
		
		System.out.println(ans);
	}
}