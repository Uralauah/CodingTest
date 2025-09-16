class Solution {
    public int len;
    
    public int solution(int[] stones, int k) {
        int answer = 0;
        len = stones.length;
        int max = Integer.MIN_VALUE;
        
        for(int i=0; i<len; i++){
            max = Math.max(max, stones[i]);
        }
        
        return find(stones, k, 0, max);
    }
    
    public int find(int[] stones, int k, int left, int right){
        if(left>right){
            return right;
        }
        int mid = (left+right)/2;
        
        int cnt = 0;
        for(int i=0;i<len;i++){
            if(stones[i] >= mid){
                cnt = 0;
                continue;
            }
            cnt++;
            if(cnt>=k){
                return find(stones, k, left, mid-1);
            }
        }
        
        return find(stones, k, mid+1, right);
    }
}