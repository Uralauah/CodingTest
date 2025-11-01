import java.util.*;

class Solution {
    public int[][] solution(int[][] rc, String[] operations) {
        int r = rc.length;
        int c = rc[0].length;
        int[][] answer = new int[r][c];
        
        ArrayDeque<Integer> left = new ArrayDeque<>();
        ArrayDeque<Integer> right = new ArrayDeque<>();
        ArrayDeque<ArrayDeque<Integer>> middle = new ArrayDeque<>();
        
        for(int i=0;i<r;i++){
            left.add(rc[i][0]);
            right.add(rc[i][c-1]);
            
            ArrayDeque<Integer> mid = new ArrayDeque<>();
            for(int j=1;j<c-1;j++){
                mid.add(rc[i][j]);
            }
            middle.add(mid);
        }
        
        for(int i=0;i<operations.length;i++){
            String op = operations[i];
            
            if(op.equals("Rotate")){
                middle.getFirst().addFirst(left.removeFirst());
                
                right.addFirst(middle.getFirst().removeLast());
                
                middle.getLast().addLast(right.removeLast());
                
                left.addLast(middle.getLast().removeFirst());
            }
            else{
                left.addFirst(left.removeLast());
                middle.addFirst(middle.removeLast());
                right.addFirst(right.removeLast());
            }
        }
        
        for(int i=0;i<r;i++){
            answer[i][0] = left.removeFirst();
            int idx = 1;
            for(int val : middle.removeFirst()){
                answer[i][idx++] = val;
            }
            answer[i][c-1] = right.removeFirst();
        }
        return answer;
    }
}