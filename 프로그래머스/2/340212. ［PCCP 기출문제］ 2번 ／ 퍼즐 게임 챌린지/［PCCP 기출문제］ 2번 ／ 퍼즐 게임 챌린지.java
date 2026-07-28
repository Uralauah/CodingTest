class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        int right = 0;
        int left = 1;
        int n = diffs.length;
        
        for(int i=0;i<n;i++){
            right = Math.max(right, diffs[i]);
        }
        
        while(left<=right){
            int mid = (left + right)/2;
            
            long time = times[0];
            
            for(int i=1;i<n;i++){
                if(diffs[i] <= mid){
                    time+=times[i];
                    continue;
                }
                
                time+=(long)(times[i-1]+times[i]) * (diffs[i] - mid);
                time+=times[i];
            }
            
            
            if(time <= limit)
                right = mid - 1;
            else
                left = mid + 1;
        }
        
        return left;
    }
}