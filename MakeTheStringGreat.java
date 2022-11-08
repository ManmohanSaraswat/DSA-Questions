import java.util.Stack;

public class MakeTheStringGreat {
    public String makeGood(String s) {
        char[] arr = s.toCharArray();
        Stack<Character> stk = new Stack<>();
        for (char ch: arr) {
            if(stk.isEmpty()) {
                stk.push(ch);
                continue;
            }
            char last = stk.peek();
            if((last ^ 32) == ch)
                stk.pop();
            else stk.push(ch);
        }
        StringBuilder res = new StringBuilder();
        while(!stk.isEmpty()){
            res.append(stk.pop());
        }
        res.reverse();
        return res.toString();
    }
}
