class Solution {
    public boolean[] visited;
    public List<List<Integer>> rooms;

    public void dfs(int key){
        for(int i=0;i<rooms.get(key).size();i++){
            int next = rooms.get(key).get(i);
            if(!visited[next]){
                visited[next] = true;
                dfs(next);
            }
        }
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        visited = new boolean[n];
        visited[0] = true;
        this.rooms = rooms;

        for(int i=0;i<rooms.get(0).size();i++){
            int next = rooms.get(0).get(i);
            if(!visited[next]){
                visited[next] = true;
                dfs(next);
            }
        }

        for(int i=0;i<n;i++){
            if(!visited[i])
                return false;
        }

        return true;

    }
}