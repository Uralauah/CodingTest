class Solution {
    public int solution(String word) {
        int[] weights = {781, 156, 31, 6, 1};
        String temp = "AEIOU";
        
        int answer = 0;
        for(int i=0;i<word.length();i++){
            int idx = temp.indexOf(word.charAt(i));
            answer += weights[i] * idx;
        }
        
        return answer + word.length();
    }
}