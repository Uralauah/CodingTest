import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer;
        int cnt = Integer.MAX_VALUE;
        int ridx = 0;
        int ml = 0;
        int mr = gems.length;
        
        Set<String> set = new HashSet<>();
        HashMap<String,Integer> map = new HashMap<>();
        
        for(int i=0;i<gems.length;i++){
            set.add(gems[i]);
        }
        
        for(int lidx=0;lidx<gems.length;lidx++){
            while(map.size()!=set.size()&&ridx<gems.length){
                map.put(gems[ridx], map.getOrDefault(gems[ridx],0)+1);
                ridx++;
            }
            if(map.size()==set.size() && mr-ml>ridx-lidx){
                mr = ridx;
                ml = lidx;
            }
            
            if(map.get(gems[lidx])==1){
                map.remove(gems[lidx]);
            }
            else{
                map.put(gems[lidx], map.get(gems[lidx])-1);
            }
        }
        
        answer = new int[]{ml+1, mr};
        return answer;
    }
}

/*
1. 모든 보석 담을때까지 오른쪽 증가
2. 왼쪽 증가시키면서 보석 현황 확인
3. 최솟값 업데이트
4. 왼쪽 증가 후 보석 모두 담지 못하면 다시 오른쪽 증가
*/