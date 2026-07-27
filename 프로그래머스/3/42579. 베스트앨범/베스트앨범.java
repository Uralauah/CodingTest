import java.util.*;

class Genre{
    public int idx;
    public int cnt;
    
    public Genre(int idx, int cnt){
        this.idx = idx;
        this.cnt = cnt;
    }
}

class Music{
    public int idx;
    public int cnt;
    
    public Music(int idx, int cnt){
        this.idx = idx;
        this.cnt = cnt;
    }
}

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        int len = genres.length;
        HashMap<String, Genre> map = new HashMap<>();
        
        ArrayList<PriorityQueue<Music>> arr = new ArrayList<>();
        
        int arrIdx = 0;
        for(int i=0;i<len;i++){
            if(map.containsKey(genres[i])){
                Genre now = map.get(genres[i]);
                now.cnt += plays[i];
                
                arr.get(now.idx).add(new Music(i,plays[i]));
            }
            else{
                map.put(genres[i], new Genre(arrIdx, plays[i]));
                arr.add(new PriorityQueue<Music>((o1,o2)->{
                    if(o1.cnt == o2.cnt) return o1.idx - o2.idx;
                    return o2.cnt - o1.cnt;
                }));
                arr.get(arrIdx++).add(new Music(i,plays[i]));
            }
            
            // Genre now = map.get(genres[i]);
            // System.out.println(now.idx);
            // Music[] m = arr.get(now.idx).toArray(new Music[0]);
            // for(int j=0;j<arr.get(now.idx).size();j++){
            //     System.out.print(m[j].idx+" ");
            // }
            // System.out.println();
        }
        
        PriorityQueue<Genre> pq = new PriorityQueue<>((o1, o2)->o2.cnt - o1.cnt);
        
        for(String key:map.keySet()){
            pq.add(map.get(key));
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        while(!pq.isEmpty()){
            Genre now = pq.poll();
            PriorityQueue<Music> musics = arr.get(now.idx);
            // System.out.println(now.idx);
            for(int j=0;j<2;j++){
                if(musics.isEmpty())
                    break;
                // System.out.println(musics.peek().idx + " "+ musics.peek().cnt);
                ans.add(musics.poll().idx);
            }
        }
        
        answer = new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            answer[i] = ans.get(i);
        }
        return answer;
    }
}

/*
Music 클래스 (인덱스, 재생 횟수)
장르별로 우선순위큐 생성, Music 클래스로 넣음 배열로 저장
재생 횟수로 정렬
장르 별 전체 재생횟수
*/