import java.util.Stack;

public class BasicCalculator {
    public int calculate(String s) {
        Stack<String> stack = new Stack<>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ')
                continue;
            if (stack.isEmpty()) {
                stack.push(arr[i] + "");
                continue;
            }
            if (arr[i] != ')') {
                if (arr[i] == '+' || arr[i] == '-')
                    stack.push(arr[i] + "");
                else {
                    if (arr[i] != '(' && Character.isDigit(stack.peek().charAt(0)))
                        stack.push(stack.pop() + arr[i]);
                    else
                        stack.push(arr[i] + "");
                }
            } else if (arr[i] == ')') {
                int res = 0;
                char op = '+';
                Stack<String> newS = new Stack<>();
                while (stack.peek().charAt(0) != '(')
                    newS.push(stack.pop());
                while (newS.isEmpty() == false) {
                    String chars = newS.pop();
                    if (chars.charAt(0) == '+' || chars.charAt(0) == '-') {
                        op = chars.charAt(0);
                    } else {
                        if (op == '+') {
                            res += Integer.parseInt(chars);
                        } else
                            res -= Integer.parseInt(chars);
                    }
                }
                stack.pop();
                if (res < 0) {
                    if (stack.isEmpty() == false && stack.peek().charAt(0) == '-')
                        stack.push("+");
                    else
                        stack.push("-");
                    stack.push(Math.abs(res) + "");
                } else {
                    stack.push(res + "");
                }
            }
        }
        char op = '+';
        int res = 0;
        Stack<String> newS = new Stack<>();
        while (stack.isEmpty() == false)
            newS.push(stack.pop());
        while (newS.isEmpty() == false) {
            String chars = newS.pop();
            if (chars.charAt(0) == '+' || chars.charAt(0) == '-') {
                op = chars.charAt(0);
            } else {
                if (op == '+') {
                    res += Integer.parseInt(chars);
                } else
                    res -= Integer.parseInt(chars);
            }
        }

        return res;
    }
}