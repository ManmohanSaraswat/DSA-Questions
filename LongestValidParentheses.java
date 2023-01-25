import java.util.Stack;

public class LongestValidParentheses{
    public int longestValidParentheses(String s) {
        char[] arr = s.toCharArray();
        Stack<Integer> stk1 = new Stack<>();
        Stack<Character> stk = new Stack<>();
        int res = 0;
        for(int i = 0; i < arr.length; i++){
            if(stk.isEmpty()){
                stk1.push(i);
                stk.push(arr[i]);
            }
            else if(stk.peek() == '(' && arr[i] == ')'){
                stk.pop();
                stk1.pop();
            }else{
                stk.push(arr[i]);
                stk1.push(i);
            }
            if(stk1.isEmpty()) res = Math.max(res, i + 1);
            else res = Math.max(res, i - stk1.peek());
        }
        return res;
    }
}