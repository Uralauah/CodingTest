class Solution {
    public int[] solution(int[] sequence, int k) {
        int n = sequence.length;
        
        int[] answer = new int[]{0, n-1};
        
        int s = 0;
        int sum = 0;
        
        for(int e = 0; e < n; e++) {
            sum += sequence[e];
            
            while(sum > k && s <= e) {
                sum -= sequence[s];
                s++;
            }
            
            if(sum == k) {
                if(e - s < answer[1] - answer[0]) {
                    answer[0] = s;
                    answer[1] = e;
                }
            }
        }
        
        return answer;
    }
}