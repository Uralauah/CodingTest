class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = health;
        
        int t = 0;
        
        for(int i=0;i<attacks.length;i++){
            int time = attacks[i][0] - t -1;
            int temp = answer + bandage[1] * time;
            temp += (time / bandage[0]) * bandage[2];
            
            answer = Math.min(health, temp);
            
            answer -= attacks[i][1];
            
            if(answer <= 0)
                return -1;
            
            t = attacks[i][0];
        }
        
        return answer;
    }
}