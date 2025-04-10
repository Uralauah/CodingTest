import java.util.*;
class Solution {
    
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        
        for(int i=0;i<balls.length;i++){
            int tarX = balls[i][0];
            int tarY = balls[i][1];
            int min = Integer.MAX_VALUE;
            
            int[][] candi = {{tarX,2*n-tarY},{tarX,-tarY},{-tarX,tarY},{2*m-tarX,tarY}};
            
            for(int j=0;j<4;j++){
                if ((j == 0 && startX == tarX && startY < tarY) ||    
                    (j == 1 && startX == tarX && startY > tarY) ||    
                    (j == 2 && startY == tarY && startX > tarX) ||    
                    (j == 3 && startY == tarY && startX < tarX)) {    
                    continue;
                }
                
                int dir_x = Math.abs(startX- candi[j][0]);
                int dir_y = Math.abs(startY - candi[j][1]);
                int temp = dir_x * dir_x + dir_y * dir_y;
                
                min = Math.min(min, temp);
            }
            answer[i]=min;
        }
        
        return answer;
    }
}
// 0+balls[i][0], 2n - balls[i][1]
// 0+balls[i][0], -balls[i][1]
// -balls[i][0],balls[i][1]
// 2m-balls[i][0],balls[i][1]