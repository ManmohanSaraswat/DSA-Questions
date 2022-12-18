import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temps) {
        Stack<Integer> stk = new Stack<>();
        int[] res = new int[temps.length];
        for (int i = temps.length - 1; i >= 0; i--) {
            while (!stk.isEmpty() && temps[i] >= temps[stk.peek()])
                stk.pop();
            if (stk.isEmpty())
                res[i] = 0;
            else
                res[i] = stk.peek() - i;
            stk.push(i);
        }
        return res;
    }
}
