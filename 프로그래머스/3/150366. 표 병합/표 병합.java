import java.util.*;

class Solution {
    public int[] parent;
    public String[] values;
    
    public int find(int a){
        if(parent[a] == a)
            return a;
        
        return parent[a] = find(parent[a]);
    }
    
    public void union(int a, int b){
        int pa = find(a);
        int pb = find(b);
        
        if(pa==pb)
            return;
        
        String mergedValue;

        if (!values[pa].equals("")) {
            mergedValue = values[pa];
        } else {
            mergedValue = values[pb];
        }

        parent[pb] = pa;
        values[pa] = mergedValue;
        values[pb] = "";
    }
    
    public int toIdx(int r, int c){
        return (r-1)*50+(c-1);
    }
    
    public String[] solution(String[] commands) {
        List<String> ans = new ArrayList<>();
        parent = new int[50*50];
        values = new String[50*50];
        for(int i=0;i<2500;i++){
            parent[i] = i;
            values[i] = "";
        }
        
        for(int i=0;i<commands.length;i++){
            StringTokenizer st = new StringTokenizer(commands[i]);
            
            String op = st.nextToken();
            
            
            
            if("UPDATE".equals(op)){
                if(st.countTokens() == 3){
                    int r = Integer.parseInt(st.nextToken());
                    int c = Integer.parseInt(st.nextToken());
                    
                    int idx = toIdx(r,c);
                    
                    values[find(idx)] = st.nextToken();
                }else{
                    String value1 = st.nextToken();
                    String value2 = st.nextToken();
                    
                    for(int j=0;j<2500;j++){
                        if(value1.equals(values[j])){
                            values[j] = value2;
                        }
                    }
                }
                
            }else if ("MERGE".equals(op)){
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int r2 = Integer.parseInt(st.nextToken());
                int c2 = Integer.parseInt(st.nextToken());
                
                int idx = toIdx(r,c);
                int idx2 = toIdx(r2, c2);
                
                union(idx, idx2);
            }else if ("UNMERGE".equals(op)){
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int idx = toIdx(r,c);
                
                int root = find(idx);
                String value = values[root];
                
                List<Integer> members = new ArrayList<>();
                for(int j=0;j<2500;j++){
                    if(find(j) == root)
                        members.add(j);
                }
                
                for(int m : members){
                    parent[m] = m;
                    values[m] = "";
                }
                
                values[idx] = value;
            }else{
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int idx = toIdx(r,c);
                
                int p = find(idx);
                if(!values[p].equals(""))
                    ans.add(values[p]);
                else
                    ans.add("EMPTY");
            }
        }
        
        String[] answer = new String[ans.size()];
        for(int i=0;i<ans.size();i++){
            answer[i] = ans.get(i);
        }
        return answer;
    }
}