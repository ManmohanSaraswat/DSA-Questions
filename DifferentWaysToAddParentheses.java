import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DifferentWaysToAddParentheses {
    Map<String, List<Integer>> dp;

    public List<Integer> solve(String str) {
        if (dp.containsKey(str))
            return dp.get(str);
        List<Integer> res = new ArrayList<>();
        int n = str.length(), ans = 0;
        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*') {
                String exp1 = str.substring(0, i);
                String exp2 = str.substring(i + 1, n);
                List<Integer> a = solve(exp1);
                List<Integer> b = solve(exp2);
                for (int x : a) {
                    for (int y : b) {
                        if (ch == '+')
                            ans = x + y;
                        else if (ch == '-')
                            ans = x - y;
                        else
                            ans = x * y;
                        res.add(ans);
                    }
                }
            }
        }
        if (res.size() == 0)
            return Arrays.asList(Integer.parseInt(str));
        dp.put(str, res);
        return res;
    }

    public List<Integer> diffWaysToCompute(String expression) {
        dp = new HashMap<>();
        return solve(expression);
    }
}
