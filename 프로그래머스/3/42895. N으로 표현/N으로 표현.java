import java.util.*;

class Solution {
    public int solution(int N, int number) {
        int answer = 0;
        
        if(N==number)
            return 1;
        
        Set<Integer>[] dp = new HashSet[9];
        for(int i=1;i<9;i++){
            dp[i] = new HashSet<>();
        }
        
        dp[1].add(N);
        
        for(int i=2;i<=8;i++){
            int num = 0;
            for(int a=0;a<i;a++){
                num=num*10+N;
            }
            dp[i].add(num);
            
            for(int j=1;j<i;j++){
                int[] arr1 = dp[j].stream().mapToInt(Integer::intValue).toArray();
                int[] arr2 = dp[i-j].stream().mapToInt(Integer::intValue).toArray();
                
                for(int k=0;k<arr1.length;k++){
                    for(int l=0;l<arr2.length;l++){
                        dp[i].add(arr1[k]+arr2[l]);
                        dp[i].add(arr1[k]-arr2[l]);
                        dp[i].add(arr1[k]*arr2[l]);
                        dp[i].add(arr1[k]/arr2[l]);
                        dp[i].add(arr2[l]-arr1[k]);
                        dp[i].add(arr2[l]/arr1[k]);
                    }
                }
            }
            if(dp[i].contains(number)){
                answer = i;
                break;
            }
            dp[i].remove(0);
        }
        
        return answer==0?-1:answer;
    }
}

/*
dp[] 배열 : dp[i] = i개의 수를 가지고 만들 수 있는 수들 리스트
dp[i] = dp[j] 사칙연산 dp[i-j]  1<=j<i
*/