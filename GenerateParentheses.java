import java.util.*;

public class GenerateParentheses {
    static List<String> res;

    private void solve(String s, int opening, int closing, int n) {
        if (opening == closing && closing == n) {
            res.add(s);
            return;
        }
        if (opening > n || closing > n)
            return;
        if (opening > closing)
            solve(s + ')', opening, closing + 1, n);
        solve(s + '(', opening + 1, closing, n);
    }

    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        solve("", 0, 0, n);
        return res;
    }
}