class Solution {
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        long left = 0;
        int max = 0;
        for(int time:times){
            max = Math.max(max, time);
        }
        long right = (long)max * n;
        
        while(left<=right){
            long mid = left+(right-left)/2;
            
            long cnt = 0;
            for(int time:times){
                cnt += mid/time;
                if(cnt >= n)
                    break;
            }
            
            // System.out.println(mid +" "+ cnt);
            
            if(cnt<n){
                left = mid+1;
            } else if(cnt>=n){
                answer = Math.min(answer,mid);
                right = mid -1;
            }
            
        }
        return answer;
    }
}

/*
1. 최소시간, 최대시간 잡기
2. 가운데 값으로 최대 몇명 심사 가능한지 계산
3. n명보다 많으면 왼쪽, 적으면 오른쪽으로 계속 이분탐색
*/
