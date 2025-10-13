class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer;
        int r = board.length;
        int c = board[0].length;
        answer = r*c;
        int[][] result = new int[r+1][c+1];
        
        for(int[] now : skill){
            int r1 = now[1];
            int r2 = now[3];
            int c1 = now[2];
            int c2 = now[4];
            int num = now[0] == 1 ? now[5]*-1 : now[5];
            
            result[r1][c1] += num;
            result[r1][c2+1] -= num;
            result[r2+1][c1] -= num;
            result[r2+1][c2+1] += num;
        }
        
        for(int i=0;i<r+1;i++){
            for(int j=1;j<c+1;j++){
                result[i][j] += result[i][j-1];
            }
        }
        
        for(int j=0;j<c+1;j++){
            for(int i=1;i<r+1;i++)
                result[i][j] += result[i-1][j];
        }
        
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                board[i][j] += result[i][j];
                if(board[i][j]<=0)
                    answer--;
            }
        }
        
//         for(int i=0;i<r;i++){
//             for(int j=0;j<c;j++)
//                 System.out.print(board[i][j]+" ");
//             System.out.println();
//         }
        
        return answer;
    }
}