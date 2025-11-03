class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int range = w*2+1;
        
        int t = (stations[0]-w-2+range)/range;
        if(t>0)
            answer+=t;

        for(int i=1;i<stations.length;i++){
            int l = stations[i-1]+w+1;
            int r = stations[i]-w;
            
            if(r<l)
                continue;
            int temp = (r-l+range-1)/range;
            if(temp>0)
                answer+=temp;
        }
        
        t = (n-stations[stations.length-1]-w+range-1)/range;
        if(t>0)
            answer+=t;
        
        return answer;
    }
}