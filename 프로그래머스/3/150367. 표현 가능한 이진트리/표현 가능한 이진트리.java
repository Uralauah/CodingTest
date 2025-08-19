import java.util.*;

class Solution {
    public String toBin(long num){
        StringBuilder sb = new StringBuilder();
        while(num>0){
            sb.insert(0,num%2);
            num/=2;
        }
        
        int len = sb.length();
        int target = 1;
        
        while(target-1<len){
            target*=2;
        }
        while(sb.length()<target-1){
            sb.insert(0,0);
        }
        
        // System.out.println(sb.toString());
        
        return sb.toString();
    }
    
    public boolean isPossible(String bin, char parent, int left, int right){
        if(left>right)
            return true;
        
        int mid = (left+right)/2;
        
        // System.out.println(parent+" "+left+" "+mid+" "+right);
        
        if(parent=='0' && bin.charAt(mid)=='1'){
            return false;
        }
        
        
        
        return isPossible(bin, bin.charAt(mid), left, mid-1) && isPossible(bin, bin.charAt(mid), mid+1, right);
    }
    
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        for(int i=0;i<numbers.length;i++){
            String bin = toBin(numbers[i]);
            
             // System.out.println(numbers[i]);
            if(isPossible(bin, '1', 0, bin.length()-1)){
                answer[i] = 1;
            }
            else{
                answer[i] = 0;
            }
        }
        return answer;
    }
}