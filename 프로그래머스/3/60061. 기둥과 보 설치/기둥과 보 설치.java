import java.util.*;

class Solution {
    public boolean[][] gi, bo;
    public int n;
    
    public boolean giCheck(int x, int y){
        if(y==0)
            return true;
        if(gi[y-1][x]==true)
            return true;
        if(x>0 && bo[y][x-1])
            return true;
        if(bo[y][x])
            return true;
        return false;
    }
    
    public boolean boCheck(int x, int y) {
        // 아래에 기둥
        if(y > 0 && gi[y-1][x]) return true;
        if(y > 0 && x+1 <= n && gi[y-1][x+1]) return true;

        // 양쪽 보
        if(x > 0 && x+1 <= n && bo[y][x-1] && bo[y][x+1]) return true;

        return false;
    }
    
    public boolean validate(int n){
        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){
                if(gi[j][i] && !giCheck(i,j)) return false;
                if(bo[j][i] && !boCheck(i,j)) return false;
            }
        }
        return true;
    }
    
    public int[][] solution(int n, int[][] build_frame) {
        int[][] answer;
        gi = new boolean[n+1][n+1];
        bo = new boolean[n+1][n+1];
        this.n = n;
        
        for(int[] now : build_frame){
            int x = now[0];
            int y = now[1];
            int kind = now[2];
            int op = now[3];
            
            if (op == 0) { // 삭제
                if (kind == 0) {
                    gi[y][x] = false;
                    if (!validate(n)) gi[y][x] = true;
                } else {
                    boolean prev = bo[y][x];
                    bo[y][x] = false;
                    if (!validate(n)) bo[y][x] = prev;
                }
            } else { // 설치
                if (kind == 0) { // 기둥
                    if (giCheck(x, y)) gi[y][x] = true;
                } else if (kind == 1) { // 보
                    if (x < n && boCheck(x, y)) bo[y][x] = true;
                }
            }
        }
        
        List<int[]> arr = new ArrayList<>();
        
        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){
                if(gi[j][i])
                    arr.add(new int[]{i,j,0});
                if(bo[j][i])
                    arr.add(new int[]{i,j,1});
            }
        }
        
        arr.sort((a1, a2)->{
            if(a1[0] == a2[0] && a1[1] == a2[1])
                return a1[2] - a2[2];
            if(a1[0] == a2[0])
                return a1[1] - a2[1];
            return a1[0] - a2[0];
        });
        
        return arr.toArray(new int[0][0]);
    }
}
/*
기둥, 보 배열 한개씩
*/