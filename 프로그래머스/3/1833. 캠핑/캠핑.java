import java.util.*;

class Solution {
    public boolean isValid(int[] a, int[] b){
        if(a[0]==b[0] || a[1]==b[1])
            return false;
        return true;
    }
    
    public int solution(int n, int[][] data) {
        int answer = 0;
        
        Arrays.sort(data, (o1, o2)->{
            if(o1[0]==o2[0])
                return o1[1] - o2[1];
            return o1[0] - o2[0];
        });
        
        // for(int i=0;i<data.length;i++){
        //     System.out.println(data[i][0]+" "+data[i][1]);
        // }
        
        for(int i=0;i<data.length;i++){
            for(int j=i+1;j<data.length;j++){
                if(!isValid(data[i], data[j]))
                    continue;
                
                // System.out.println(data[i][0]+" "+data[i][1]+" "+data[j][0]+" "+data[j][1]);
                
                boolean flag = true;
                for(int k=i+1;k<j;k++){
                    int minX = Math.min(data[i][0],data[j][0]);
                    int maxX = Math.max(data[i][0],data[j][0]);
                    int minY = Math.min(data[i][1],data[j][1]);
                    int maxY = Math.max(data[i][1],data[j][1]);
                    if(minX<data[k][0] && maxX>data[k][0] && minY<data[k][1] && maxY>data[k][1]){
                        flag = false;
                        break;
                    }
                }
                
                if(!flag)
                    continue;
                answer++;
            }
        }
        
        return answer;
    }
}