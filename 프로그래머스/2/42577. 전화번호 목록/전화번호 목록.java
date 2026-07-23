import java.util.HashSet;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashSet<String> hs = new HashSet<>();
        for(int i=0;i<phone_book.length;i++){
            hs.add(phone_book[i]);
        }
        
        for(String tmp : hs){
            for(int i = 1; i<tmp.length();i++){
                if(hs.contains(tmp.substring(0,i)))
                    return false;
            }
        }
        
        return answer;
    }
}