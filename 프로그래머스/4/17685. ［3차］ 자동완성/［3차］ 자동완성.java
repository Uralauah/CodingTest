import java.util.*;

class Solution {
    public class Trie {
        Map<Character, Trie> child = new HashMap<>();
        boolean isEnd = false;
        int count = 0;
    }
    
    public Trie trie;
    
    public void add(String word){
        Trie now = trie;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(!now.child.containsKey(c)){
                now.child.put(c, new Trie());
            }
            now.count++;
            now = now.child.get(c);
        }
        now.count++;
        now.isEnd = true;
    }
    
    public int find(String word){
        Trie now = trie;
        for(int i=0;i<word.length();i++){
            if(now.count == 1){
                return i;
            }
            char c = word.charAt(i);
            now = now.child.get(c);
        }
        return word.length();
    }
    
    public int solution(String[] words) {
        int answer = 0;
        
        trie = new Trie();
        
        for(int i=0;i<words.length;i++){
            add(words[i]);
        }
        
        for(int i=0;i<words.length;i++){
            answer += find(words[i]);
        }
        return answer;
    }
}