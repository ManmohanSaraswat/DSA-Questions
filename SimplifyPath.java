import java.util.Stack;

public class SimplifyPath {
    public String simplifyPath(String path) {
        String[] strs = path.split("/");
        Stack<String> stk = new Stack<>();
        for (String str : strs) {
            if (str.equals("..") && stk.size() > 0)
                stk.pop();
            else if (str.length() > 0 && !str.equals(".") && !str.equals(".."))
                stk.push(str);
        }
        if (stk.isEmpty())
            return "/";
        StringBuilder res = new StringBuilder();
        while (!stk.isEmpty())
            res.insert(0, "/" + stk.pop());
        return res.toString();
    }
}
