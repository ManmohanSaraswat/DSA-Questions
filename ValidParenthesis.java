import java.util.Stack;

public class ValidParenthesis {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        int n = s.length();
        for(int i = 1; i < n; i++){
            if(stack.isEmpty()){
                stack.push(s.charAt(i));
                continue;
            }
            Character inStack = stack.peek();
            if((inStack == '(' && s.charAt(i) == ')') || (inStack == '{' && s.charAt(i) == '}') || (inStack == '[' && s.charAt(i) == ']'))
                stack.pop();
            else
                stack.push(s.charAt(i));
        }
        return stack.isEmpty() ? true : false;
    }
}
