public class Solution {
    public int[][] land;
    public int P,Q,n;
    public long answer = Long.MAX_VALUE;
    
    public long cost(long mid){
        long temp = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(mid>land[i][j]){
                    temp += (mid-land[i][j])*P;
                }
                else{
                    temp += (land[i][j]-mid)*Q;
                }
            }
        }
        return temp;
    }
    
    public void find(long left, long right){
        if(left>=right)
            return;
        long mid = (left+right)/2;
        
        long cost1 = cost(mid);
        long cost2 = cost(mid+1);
        
        
        if(cost1<cost2){
            if(answer>cost1){
                answer = cost1;
            }
            find(left,mid-1);
        }
        else{
            if(answer>cost2){
                answer = cost2;
            }
            find(mid+1,right);
        }
    }
    
    public long solution(int[][] land, int P, int Q) {
        n = land.length;
        this.land = land;
        this.P = P;
        this.Q = Q;
        
        
        long right = 0;
        long left = Long.MAX_VALUE;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                right = Math.max(right, land[i][j]);
                left = Math.min(left, land[i][j]);
            }
        }
        
        while(left < right){
            long mid = (left + right) / 2;

            long c1 = cost(mid);
            long c2 = cost(mid + 1);

            if(c1 <= c2) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return cost(left);
    }
}
//이분탐색??