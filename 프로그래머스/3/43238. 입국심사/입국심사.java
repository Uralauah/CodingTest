class Solution {
    public long solution(int n, int[] times) {
        long left = 0;
        long right = 0;
        
        for(int i=0;i<times.length;i++){
            right = Math.max(right, times[i]);
        }
        
        right *= n;
        
        while(left < right){
            long mid = (left+right)/2;
            
            long cnt = 0;
            for(int i=0;i<times.length;i++){
                cnt += mid / times[i];
            }
            
            if(cnt >= n){
                right = mid;
            }
            else{
                left = mid+1;
            }
        }
        
        
        return left;
    }
}

// 0 30 60 7
// 0 15 30 3
// 16 23 30 5
// 24 27 30 5
// 28 29 30 6

    