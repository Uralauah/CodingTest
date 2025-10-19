import java.util.*;

class Solution {
    public char[][] tile;
    public int m,n;
    
    public boolean isClearRow(int x, int y, int a, int b){
        if(x>a){
            int t = x;
            x = a;
            a = t;
        }
        x++;
        for(;x<a;x++){
            if(tile[x][y]!='.')
                return false;
        }
        return true;
    }
    
    public boolean isClearCol(int x, int y, int a, int b){
        if(y>b){
            int t = y;
            y = b;
            b = t;
        }
        y++;
        for(;y<b;y++){
            if(tile[x][y]!='.')
                return false;
        }
        return true;
    }
    
    public boolean canConnect(int x, int y, int a, int b){
        if (x==a && isClearCol(x,y,a,b))
            return true;
        if (y==b && isClearRow(x,y,a,b))
            return true;
        
        if(tile[x][b]=='.' && isClearCol(x,y,x,b) && isClearRow(x,b,a,b))
            return true;
        
        if(tile[a][y]=='.' && isClearCol(a,y,a,b) && isClearRow(x,y,a,y))
            return true;
        
        return false;
    }
    
    public String solution(int m, int n, String[] board) {
        this.m = m;
        this.n = n;
        tile = new char[m][n];
        
        Set<Character> set = new HashSet<>();
        Map<Character, List<int[]>> map = new HashMap<>();
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                char now = board[i].charAt(j);
                tile[i][j] = now;
                if(now >='A' && now<='Z'){
                    set.add(now);
                    map.computeIfAbsent(now, k -> new ArrayList<>()).add(new int[]{i,j});
                }
            }
        }
        
        List<Character> letters = new ArrayList<>(set);
        Collections.sort(letters);
        StringBuilder sb = new StringBuilder();
        
        while(!set.isEmpty()){
            boolean isRemove = false;
            
            for(char letter : letters){
                List<int[]> now = map.get(letter);
                if(!set.contains(letter) || now.size() != 2)
                    continue;
                
                int[] a = now.get(0);
                int[] b = now.get(1);
                
                if(canConnect(a[0],a[1],b[0],b[1])){
                    tile[a[0]][a[1]] = '.';
                    tile[b[0]][b[1]] = '.';
                    set.remove(letter);
                    sb.append(letter);
                    isRemove = true;
                    break;
                }
            }
            
            if(!isRemove)
                return "IMPOSSIBLE";
        }
        
        return sb.toString();
    }
}