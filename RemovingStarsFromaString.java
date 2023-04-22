import java.util.Stack;

public class RemovingStarsFromaString {
    public String removeStars(String s) {
        Stack<Character> stk = new Stack<>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '*')
                stk.pop();
            else
                stk.push(arr[i]);
        }
        StringBuilder res = new StringBuilder();
        while (!stk.isEmpty()) {
            res.append(stk.pop());
        }
        return res.reverse().toString();
    }
}
