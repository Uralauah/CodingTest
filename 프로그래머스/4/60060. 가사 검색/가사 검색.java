import java.util.*;

class Solution {
    public class Node{
        public Map<Character,Node> children;
        public Map<Integer,Integer> len;
        
        public Node(){
            children = new HashMap<>();
            len = new HashMap<>();
        }
    }
    
    public class Trie{
        public Node node;
        
        public Trie(){
            node = new Node();
        }
        
        public void insert(String word){
            Node now = this.node;
            for(int i=0;i<word.length();i++){
                char c = word.charAt(i);
                now.children.putIfAbsent(c,new Node());
                now.len.compute(word.length(),(k,v)->v==null?1:v+1);
                now = now.children.get(c);
            }
        }
        
        public int find(String keyword){
            int ans = 0;
            Node now = this.node;
            
            if(keyword.charAt(0)=='?')
                ans = now.len.getOrDefault(keyword.length(),0);
            
            for(int i=0;i<keyword.length();i++){
                char c = keyword.charAt(i);
                
                if(c=='?')
                    break;
                
                if(!now.children.containsKey(c))
                    return 0;
                
                now = now.children.get(c);
                ans = now.len.getOrDefault(keyword.length(),0);
            }
            return ans;
        }
    }
    
    public int[] solution(String[] words, String[] queries) {
        int n = queries.length;
        int[] answer = new int[n];
        
        Trie trie = new Trie();
        Trie eirt = new Trie();
        
        for(int i=0;i<words.length;i++){
            String word = words[i];
            trie.insert(word);
            eirt.insert(new StringBuilder(word).reverse().toString());
        }
        
        for(int i=0;i<n;i++){
            String keyword = queries[i];
            
            if(keyword.charAt(0)!='?'){
                answer[i] = trie.find(keyword);
            }
            else{
                answer[i] = eirt.find(new StringBuilder(keyword).reverse().toString());
            }
        }
         
        return answer;
    }
}