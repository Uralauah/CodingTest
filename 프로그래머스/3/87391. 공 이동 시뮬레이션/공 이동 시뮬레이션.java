class Solution {
    public long solution(int n, int m, int x, int y, int[][] queries) {
        long answer = -1;
        long sx = x, ex= x, sy = y, ey = y;
        
        for(int i=queries.length-1;i>=0;i--){
            int op = queries[i][0];
            int dist = queries[i][1];
            
            switch(op){
                case 0: //열 증가
                    sy = (sy==0)?0:sy+dist;
                    ey = Math.min(ey+dist, m-1);
                    break;
                case 1: //열 감소
                    sy = Math.max(sy-dist, 0);
                    ey = (ey==m-1)?m-1:ey-dist;
                    break;
                case 2: //행 증가
                    sx = (sx==0)?0:sx+dist;
                    ex = Math.min(ex+dist,n-1);
                    break;
                case 3: //행 감소
                    sx = Math.max(sx-dist,0);
                    ex = (ex==n-1)?n-1:ex-dist;
                    break;
            }
            if(sx>ex || sy>ey)
                return 0;
        }
        
        return (ex-sx+1)*(ey-sy+1);
    }
}