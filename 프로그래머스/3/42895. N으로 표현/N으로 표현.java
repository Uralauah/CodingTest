import java.util.*;

class Solution {
    public int solution(int N, int number) {
        int answer = -1;
        
        Set<Integer>[] dp = new HashSet[9];
        int t = N;
        for(int i=1;i<=8;i++){
            dp[i] = new HashSet<>();
            dp[i].add(t);
            if(t == number)
                return i;
            t = t*10 + N;
        }
        
        dp[1].add(N);
        
        for(int i=2;i<=8;i++){
            for(int j=1;j<i;j++){
                int k = i-j;
                
                for(int a : dp[j]){
                    for(int b : dp[k]){
                        dp[i].add(a+b);
                        dp[i].add(a*b);
                        dp[i].add(a-b);
                        if(b!=0)
                            dp[i].add(a/b);
                        
                        if(dp[i].contains(number)){
                            return i;
                        }
                    }
                }
            }
        }
        return answer;
    }
}