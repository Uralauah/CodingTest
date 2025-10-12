import java.util.*;

class Solution {
    public class Del{
        public int num;
        public int prev;
        public int next;
        
        public Del(int num, int prev,int next){
            this.num = num;
            this.prev = prev;
            this.next = next;
        }
    }
    
    public String solution(int n, int k, String[] cmd) {
        int[] prev = new int[n];
        int[] next = new int[n];
        Deque<Del> stack = new ArrayDeque<>();
        
        for(int i=0;i<n;i++){
            prev[i] = i-1;
            next[i] = i == n-1 ? -1 : i+1;
        }
        
        for(String now : cmd){
            char op = now.charAt(0);
            if(op == 'U' || op == 'D'){
                int move = Integer.parseInt(now.substring(2).trim());
                
                if(op == 'U'){
                    for(;move>0;move--){
                        k = prev[k];
                    }
                } else{
                    for(;move>0;move--){
                        k = next[k];
                    }
                }
            }
            else if(op=='C'){
                stack.push(new Del(k,prev[k], next[k]));
                
                if(prev[k]!=-1)
                    next[prev[k]] = next[k];
                if(next[k]!=-1)
                    prev[next[k]] = prev[k];
                
                k = next[k]==-1 ? prev[k] : next[k];
            }
            else if(op=='Z'){
                Del redo = stack.pop();
                
                if(redo.prev!=-1)
                    next[redo.prev] = redo.num;
                if(redo.next!=-1)
                    prev[redo.next] = redo.num;
                
                prev[redo.num] = redo.prev;
                next[redo.num] = redo.next;
            }
        }
        
        char[] ans = new char[n];
        Arrays.fill(ans, 'O');
        for(Del now : stack){
            ans[now.num] = 'X';
        }
        return new String(ans);
    }
}