import java.util.Stack;

public class ParsingABooleanExpression {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> stkVals = new Stack<>();
        Stack<Character> stkExp = new Stack<>();
        char[] arr = expression.toCharArray();
        for (Character ch : arr) {
            if (ch == 't' || ch == 'f' || ch == '(') {
                stkVals.push(ch);
            } else if (ch == '&' || ch == '|' || ch == '!') {
                stkExp.push(ch);
            } else if (ch == ')') {
                char ab = stkExp.pop();
                boolean temp = stkVals.peek() == 't';
                while (stkVals.peek() != '(') {
                    if (ab == '&') {
                        temp = temp & (stkVals.peek() == 't');
                    } else if (ab == '|') {
                        temp = temp | (stkVals.peek() == 't');
                    } else {
                        temp = !temp;
                    }
                    stkVals.pop();
                }
                stkVals.pop();
                stkVals.push(temp ? 't' : 'f');
            }
        }
        return stkVals.pop() == 't';
    }
}
