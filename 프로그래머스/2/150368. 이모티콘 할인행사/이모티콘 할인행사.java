class Solution {
    public int n;
    public int[][] users;
    public int[] answer, emoticons;
    public int[] discount;
    public int[] rates = {10, 20, 30, 40};

    public void find(int idx, int[] price){
        if(idx == n){ 
            calc(price); 
            return;
        }

        for(int i=0;i<4;i++){
            discount[idx] = rates[i];
            price[idx] = emoticons[idx] * (100 - rates[i]) / 100;
            find(idx+1, price);
        }
    }
    
    public void calc(int[] price){
        int sign = 0;
        int buy = 0;

        for(int i=0;i<users.length;i++){
            int needRate = users[i][0];
            int needPrice = users[i][1];
            
            int sum = 0;

            for(int j=0;j<n;j++){
                if(discount[j] >= needRate){
                    sum += price[j];
                }
            }

            if(sum >= needPrice){
                sign++;
            } else {
                buy += sum;
            }
        }

        if(answer[0] < sign){
            answer[0] = sign;
            answer[1] = buy;
        }
        else if(answer[0] == sign && answer[1] < buy){
            answer[1] = buy;
        }
    }
    
    public int[] solution(int[][] users, int[] emoticons) {
        answer = new int[2];
        n = emoticons.length;
        int[] price = new int[n];
        
        this.users = users;
        this.emoticons = emoticons;
        this.discount = new int[n];

        find(0, price);
        
        return answer;
    }
}
