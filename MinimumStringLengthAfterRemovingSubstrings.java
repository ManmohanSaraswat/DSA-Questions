import java.util.Stack;

public class MinimumStringLengthAfterRemovingSubstrings {
    public int minLength(String s) {
        char[] arr = s.toCharArray();
        Stack<Character> stk = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            stk.push(arr[i]);
            if (stk.size() >= 2) {
                char a = stk.pop();
                if (a == 'B' && stk.peek() == 'A')
                    stk.pop();
                else if (a == 'D' && stk.peek() == 'C')
                    stk.pop();
                else
                    stk.push(a);
            }
        }
        return stk.size();
    }
}
