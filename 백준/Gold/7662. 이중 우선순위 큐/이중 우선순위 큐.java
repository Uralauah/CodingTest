import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		TreeMap<Integer, Integer> map = new TreeMap<>();

		StringTokenizer st;
		for (int t = 0; t < T; t++) {
			int k = Integer.parseInt(br.readLine());

			map.clear();

			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());

				String op = st.nextToken();
				int num = Integer.parseInt(st.nextToken());

				if (op.equals("I")) {
					map.put(num, map.getOrDefault(num, 0) + 1);
				} else {
					if(map.isEmpty())
						continue;
					int key = num == 1 ? map.lastKey() : map.firstKey();
					if (map.get(key) == 1)
						map.remove(key);
					else
						map.put(key, map.get(key) - 1);
				}
			}

			if(map.isEmpty())
				System.out.println("EMPTY");
			else {
				System.out.println(map.lastKey()+" "+map.firstKey());
			}
		}

	}
}
