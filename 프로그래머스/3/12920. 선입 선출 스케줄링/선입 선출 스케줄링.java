import java.util.*;

class Solution {
    public int solution(int n, int[] cores) {
        int answer = 0;
        long r = 100000*50000;
        long l = 0;
        long time = 0;
        
        while(l<r){
            long mid = (r+l)/2;
            
            long sum = cores.length;
            for(int i=0;i<cores.length;i++){
                sum+=mid/cores[i];
            }
            if(sum>=n){
                r = mid;
                time = mid;
                continue;
            }
            l = mid+1;
        }
        
        long done = cores.length;
        
        for(int c : cores)
            done += (time-1)/c;
        
        for(int i=0;i<cores.length;i++){
            if(time%cores[i]==0){
                done++;
                if(done==n)
                    return i+1;
            }
        }
        
        return answer;
    }
}