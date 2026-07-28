class Solution {
    public int[] solution(int brown, int yellow) {
        
        int total = brown+yellow;
        
        for(int w=3;w*w<=total;w++){
            if(total%w!=0)
                continue;
            
            int h = total/w;
            
            if((w-2)*(h-2) == yellow)
                return new int[]{h,w};
        }
        
        
        return new int[]{};
    }
}