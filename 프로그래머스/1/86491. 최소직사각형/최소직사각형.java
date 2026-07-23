class Solution {
    public int solution(int[][] sizes) {
        int width = 0;
        int height = 0;
        
        for(int i=0;i<sizes.length;i++){
            if(sizes[i][0] > sizes[i][1]){
                width = Math.max(width, sizes[i][0]);
                height = Math.max(height, sizes[i][1]);
            }
            else{
                width = Math.max(width, sizes[i][1]);
                height = Math.max(height, sizes[i][0]);
            }
            
        }
        
        return width * height;
    }
}