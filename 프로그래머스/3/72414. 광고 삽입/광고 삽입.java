import java.util.*;

class Solution {
    public int strToInt(String time){
        StringTokenizer st = new StringTokenizer(time, ":");
        int sec = 0;
        int t = 60*60;
        while(st.hasMoreTokens()){
            sec += Integer.parseInt(st.nextToken())*t;
            t/=60;
        }
        return sec;
    }
    
    public String intToStr(int time){ 
        int h = time/3600;
        time %= 3600;
        int m = time/60;
        time %= 60;
        return String.format("%02d:%02d:%02d",h,m,time);
    }
    
    public String solution(String play_time, String adv_time, String[] logs) {
        if(play_time.equals(adv_time))
            return intToStr(0);
        
        int ptime = strToInt(play_time);
        int atime = strToInt(adv_time);
        
        long[] viewer = new long[ptime+1];
        
        for(int i=0;i<logs.length;i++){
            StringTokenizer st = new StringTokenizer(logs[i],"-");
            int from = strToInt(st.nextToken());
            int to = strToInt(st.nextToken());
            
            viewer[from] +=1;
            viewer[to] -=1;
        }
        
        for(int i=1;i<ptime+1;i++){
            viewer[i]+=viewer[i-1];
        }
        
        for(int i=1;i<ptime+1;i++){
            viewer[i]+=viewer[i-1];
        }
        
        long max = viewer[atime];
        int start = 0;
        
        for(int i=1;i<ptime+1-atime;i++){
            long now = viewer[i+atime-1] - viewer[i-1];
            if(max<now){
                max = now;
                start = i;
            }
        }
        
        return intToStr(start);
    
    }
}