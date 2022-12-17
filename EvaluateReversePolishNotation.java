import java.util.Stack;

public class EvaluateReversePolishNotation{
    class Solution {
        public int evalRPN(String[] tokens) {
            Stack<Integer> stk = new Stack<>();
            for(String token: tokens){
                if(token.length() == 1){
                    char ch = token.charAt(0);
                    if(ch >= '0' && ch <= '9'){
                        stk.push(Integer.parseInt(token));
                    }else{
                        int rightOp = stk.pop();
                        int leftOp = stk.pop();
                        int res = 0;
                        switch(ch){
                            case '+': res = leftOp + rightOp;
                                break;
                            case '-': res = leftOp - rightOp;
                                break;
                            case '*': res = leftOp * rightOp;
                                break;
                            case '/': res = leftOp / rightOp;
                                break;
                        }
                        stk.push(res);
                    }
                }else
                    stk.push(Integer.parseInt(token));
            }
            return stk.pop();
        }
    }
}