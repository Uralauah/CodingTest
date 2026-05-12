class Solution {
    boolean solution(String s) {
        boolean answer = false;

        int p = 0; 
        int y = 0;
        s = s.toLowerCase();
        
        for(int i=0;i<s.length();i++){
            char now = s.charAt(i);
            if(now == 'p'){
                p++;
            }else if(now == 'y'){
                y++;
            }
        }
        
        if(p==y)
            answer = true;
        return answer;
    }
}