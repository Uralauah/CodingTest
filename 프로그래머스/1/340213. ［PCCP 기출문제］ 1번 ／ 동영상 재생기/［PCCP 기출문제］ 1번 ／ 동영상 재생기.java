class Solution {
    public int toInt(String time){
        int h = Integer.parseInt(time.substring(0,2));
        int m = Integer.parseInt(time.substring(3));
        
        return h*60+m;
    }
    
    public String toString(int time){
        String h = String.valueOf(time/60);
        String m = String.valueOf(time%60);
        
        if(h.length()==1)
            h = "0"+h;
        if(m.length()==1)
            m = "0"+m;
        
        return h+":"+m;
    }
    
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        
        int len = toInt(video_len);
        int now = toInt(pos);
        int opS = toInt(op_start);
        int opE = toInt(op_end);
        
        for(int i=0;i<commands.length+1;i++){
            if(now>=opS && now<=opE){
                now = opE;
            }
            if(i>=commands.length)
                break;
            
            if("next".equals(commands[i])){
                now = Math.min(now+10, len);
            }
            else{
                now = Math.max(now-10, 0);
            }
        }
        
        return toString(now);
    }
}