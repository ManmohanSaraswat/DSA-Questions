import java.util.*;

public class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stk = new Stack<>();
        int left = 0, right = 0;
        while (left < pushed.length && right < popped.length) {
            if (!stk.isEmpty() && stk.peek() == popped[right]) {
                stk.pop();
                right++;
            } else {
                stk.push(pushed[left]);
                left++;
            }
        }
        while (right < popped.length && !stk.isEmpty() && stk.peek() == popped[right]) {
            right++;
            stk.pop();
        }
        return stk.isEmpty();
    }
}
