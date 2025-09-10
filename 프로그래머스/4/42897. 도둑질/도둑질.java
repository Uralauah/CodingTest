class Solution {
    public int solution(int[] money) {
        int len = money.length;
        
        return Math.max(rob(0,len-2, money), rob(1,len-1,money));
    }
    
    public int rob(int s, int e, int[] money){
        int prev2 = 0;
        int prev1 = 0;
        // System.out.println(s+" asdf "+e);
        for(int i=s;i<=e;i++){
            int steal = prev2 + money[i];
            int notSteal = prev1;
            int cur = Math.max(steal, notSteal);
            prev2 = prev1;
            prev1 = cur;
            
            
            // System.out.println(prev1+" "+prev2);
        }
        return prev1;
    }
//     public int solution(int[] money) {
//         int len = money.length;
//         int[][] dpA = new int[len][2];
//         int[][] dpB = new int[len][2];
        
//         dpA[0][0] = money[0];
//         for(int i=1;i<len;i++){
//             dpB[i][0] = dpB[i-1][1]+money[i];
//             dpB[i][1] = Math.max(dpB[i-1][0], dpB[i-1][1]);
            
//             if(i==len-1)
//                 break;
//             dpA[i][0] = dpA[i-1][1]+money[i];
//             dpA[i][1] = Math.max(dpA[i-1][0], dpA[i-1][1]);
            
//         }
        
//         int a = Math.max(dpA[len-2][0], dpA[len-2][1]);
        
//         int b = Math.max(dpB[len-1][0], dpB[len-1][1]);
        
//         return Math.max(a,b);
//     }
}
/*
2차원 배열 dp
[n][0] 해당 집에서 돈 훔쳤을 때 최댓값
[n][1] 해당 집에서 돈 훔치지 않았을 때 최댓값

돈을 훔쳤으면 [n][0] = Math.max([n-1][1]+money[n], [n][0])
안훔쳤으면 [n][1] = Math.max([n-1][0], [n-1][1])
*/