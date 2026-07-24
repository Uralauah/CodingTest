class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        int n = sequence.length;
        
        long[] maxDp = new long[n];
        long[] minDp = new long[n];
        
        maxDp[0] = sequence[0];
        minDp[0] = sequence[0];
        
        long max = maxDp[0];
        long min = maxDp[0];
        
        for(int i=1;i<n;i++){
            long cur = i%2==0 ? sequence[i] : -sequence[i];
            
            maxDp[i] = Math.max(cur, maxDp[i-1] + cur);
            minDp[i] = Math.min(cur, minDp[i-1] + cur);
            
            max = Math.max(max, maxDp[i]);
            min = Math.min(min, minDp[i]);
        }
        
        return Math.max(max, -min);
    }
}