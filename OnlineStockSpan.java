import java.util.Map;
import java.util.Stack;

public class OnlineStockSpan {
    class StockSpanner {
        Stack<Map.Entry<Integer, Integer>> stack;
        int index;
    
        public StockSpanner() {
            stack = new Stack<>();
            index = 0;
        }
    
        public int next(int price) {
            index++;
            if (stack.isEmpty() || stack.peek().getKey() > price) {
                stack.push(Map.entry(price, index));
                return 1;
            } else {
                while (!stack.isEmpty() && stack.peek().getKey() <= price) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    stack.push(Map.entry(price, index));
                    return index;
                }
                int ans = index - stack.peek().getValue();
                stack.push(Map.entry(price, index));
                return ans;
            }
        }
    }
}