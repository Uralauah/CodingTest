import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
	
	static int count;
	static List<String> words;
	
	static class Node {
		Map<Character, Node> child = new HashMap<>(); // 이 노드의 자식 노드들 
		boolean isEnd; // 이 글자가 한 단어의 끝임을 체크해주는 변수 
	}
	
	static Node root;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String line;
		
		// 테케들 입력받기 
		while((line = br.readLine()) != null) { // 입력이 없으면 종료 
			
			int N = Integer.parseInt(line); // 사전에 속한 단어의 개수 
			
			words = new ArrayList<>(); // 사전에 속한 단어들 정보 
			root = new Node(); // 트리의 루트 노드 (매 테케마다 초기화 해줘야 함을 잊지 말기!)
			
			// 사전 정보 입력받기
			for(int i=0; i<N; i++) {
				String word = br.readLine(); // hello
				
				// 단어들 저장해주기 
				words.add(word); 
				
				Node cur = root; // 루트 노드에서 시작 (매 단어마다 root로 초기화 해줘야 한다는 점!)
				
				// 트라이에 단어 삽입 
				for(int j=0; j<word.length(); j++) {
					
					char letter = word.charAt(j);
					
					// 자식 중에 이 노드가 없으면 새로 만들고, 있으면 그대로 쓰기!
					cur.child.putIfAbsent(letter, new Node());
					
					// 해당 노드로 이동 
					cur = cur.child.get(letter);
				}
				
				// 단어 다 삽입했으면 마지막 노드임을 체크 
				cur.isEnd = true;
			}
			
			int total = 0; // 모든 count들의 합 
			
			// 단어마다 버튼을 눌러야 하는 횟수 구하기
			for(String word :  words) { // 각 단어마다 
				
				// 이 단어에 대해 버튼을 눌러야 하는 횟수 구하기
				total += countButton(word);
			}
			
			double answer = (double) total / words.size();
			
			sb.append(String.format("%.2f", answer)).append("\n");
		}
		System.out.println(sb);
	}
	
	// 트라이를 따라 내려가면서 이 단어에 대해 버튼을 눌러야 하는 횟수 구하기 - 시작할 때, 이전 노드가 분기할 때, 이전 노드가 한 단어의 끝이었을 때. 
	private static int countButton(String word) {
		
		int count = 0; // 이 단어에 대해 버튼을 눌려야 하는 횟수 
		Node cur = root; // 루트에서 시작 
		
		// 시작할 때 버튼 누르기 
		for(int i=0; i<word.length(); i++) {
			
			char letter = word.charAt(i); 
			
			// 시작할 때 버튼 누르기 
			if(i == 0) {
				count++;
			}
			
			// 이전 노드가 분기할 때 버튼 누르기 (child가 1개보다 많을 때)
			else if(cur.child.size() > 1) count++;
			
			// 이전 노드가 한 단어의 끝이었을 때 버튼 누르기. <- 그러려면 이 노드가 한 단어의 끝임을 체크해줘야 함 
			else if(cur.isEnd) count++;
			
			// cur 이동
			cur = cur.child.get(letter);
			
		}
		return count;
	}
	

}
