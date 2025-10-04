class Solution
{
    public int solution(String s)
    {
        int answer = 1;

        int len = s.length();
        
        for(int i=1;i<len-1;i++){
            int j=0;
            // System.out.println("start: "+s.charAt(i));
            boolean flag = false;
            while(i-j>=0 && i+j<len){
                
                // System.out.println(s.charAt(i-j) +" "+s.charAt(i+j));
                if(s.charAt(i-j) != s.charAt(i+j)){
                    // System.out.println("wrong!");
                    break;
                }    
                j++;
            }
            answer = Math.max(answer, 1+((j-1)*2));
        }
        
        for(int i=0;i<len-1;i++){
            int j=0;
            while(i-j>=0 && i+j+1<len){
                // System.out.println(s.charAt(i-j) +" "+s.charAt(i+j+1)+" : "+(i-j)+" "+(i+j+1));
                
                if(s.charAt(i-j) != s.charAt(i+j+1)){
                    // System.out.println("wrong!");
                    break;
                }
                j++;
            }
            answer = Math.max(answer, j*2);
        }

        return answer;
    }
}