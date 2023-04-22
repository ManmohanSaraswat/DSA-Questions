import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        char arr[] = s.toCharArray();
        Stack<Character> stk = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(' || arr[i] == '{' || arr[i] == '[') {
                stk.push(arr[i]);
            } else {
                if (stk.isEmpty())
                    return false;
                char ch = stk.peek();
                if ((ch == '(' && arr[i] == ')') || (ch == '[' && arr[i] == ']') || (ch == '{' && arr[i] == '}'))
                    stk.pop();
                else
                    return false;
            }
        }
        return stk.isEmpty();
    }
}
