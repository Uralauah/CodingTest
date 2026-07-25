class Solution {
    public int[] memo;
    public int maxInt;

    public int dfs(int used, int remain){
        if(memo[used] != 0)
            return memo[used];

        for(int i=1;i<=maxInt;i++){
            if((used|(1<<i)) == used)
                continue;

            if(remain <= i){
                memo[used] = 1;
                return 1;
            }

            if(dfs(used|(1<<i), remain-i) == -1){
                memo[used] = 1;
                return 1;
            }
        }

        memo[used] = -1;
        return -1;
    }

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        maxInt = maxChoosableInteger;

        int sum = 0;
        for(int i=1;i<=maxInt;i++){
            sum+=i;
        }
        if(sum < desiredTotal)
            return false;

        memo = new int[1<<maxInt+1];

        return dfs(0,desiredTotal) == 1 ? true : false;
    }
}