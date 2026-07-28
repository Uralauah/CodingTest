import java.util.*;

class Solution {
    public boolean[] isPrime;
    public String[] number;
    
    public void prime(){
        for(int i=0;i<10000000;i++){
            isPrime[i] = true;
        }
        
        isPrime[0] = false;
        isPrime[1] = false;
        
        for(int i=2;i<Math.sqrt(10000000);i++){
            if(isPrime[i]){
                for(int j=i*i;j<10000000;j+=i){
                    isPrime[j] = false;
                }
            }
        }
    }
    
    public Set<Integer> ans;
    
    public boolean[] visited;
    
    public void dfs(String current){
        if(!current.isEmpty()){
            int num = Integer.parseInt(current);
            if(isPrime[num]){
                ans.add(num);
            }
        }
        
        for(int i=0;i<number.length;i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(current+number[i]);
                visited[i] = false;
            }
        }
    }
    
    public int solution(String numbers) {
        
        isPrime = new boolean[10000000];
        prime();
        number = new String[numbers.length()];
        for(int i=0;i<numbers.length();i++){
            number[i] = numbers.substring(i,i+1);
        }
        
        ans = new HashSet<>();
        visited = new boolean[numbers.length()];
        
        dfs("");
        
        return ans.size();
    }
}