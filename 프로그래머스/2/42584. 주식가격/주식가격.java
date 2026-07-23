import java.util.*;

class Solution {
    public class Stock{
        int price;
        int idx;
        
        public Stock(int price, int idx){
            this.price = price;
            this.idx = idx;
        }
    }
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        ArrayDeque<Stock> stack = new ArrayDeque<>();
        
        stack.push(new Stock(prices[0], 0));
        
        for(int i=1;i<prices.length;i++){
            while(!stack.isEmpty()){
                if(stack.peek().price > prices[i]){
                    int idx = stack.peek().idx;
                    answer[idx] = i - idx;
                    stack.poll();
                    continue;
                }
                break;
            }
            stack.push(new Stock(prices[i], i));
        }
        
        while(!stack.isEmpty()){
            int idx = stack.peek().idx;
            answer[idx] = prices.length -1 -idx;
            stack.poll();
        }
        
        return answer;
    }
}