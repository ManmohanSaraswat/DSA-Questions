import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    static List<List<String>> res;
    String s;

    public List<List<String>> partition(String st) {
        res = new ArrayList<>();
        s = st;
        solveEfficient(st, new ArrayList<>());
        return res;
    }

    public void solveEfficient(String str, List<String> cur) {
        if (str.length() == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 1; i <= str.length(); i++) {
            String current = str.substring(0, i);
            if (!isPalindrome(current))
                continue;
            cur.add(current);
            solveEfficient(str.substring(i), cur);
            cur.remove(cur.size() - 1);
        }
    }

    private boolean isPalindrome(String str) {
        if (str.length() == 0)
            return false;
        int start = 0, end = str.length() - 1;
        while (start < end) {
            if (str.charAt(start) != str.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }

    public void solveInefficient(String str, int n, List<String> ans) {
        if (n == s.length()) {
            if (isPalindrome(str)) {
                ans.add(str);
                List<String> copy = new ArrayList<>(ans);
                res.add(copy);
            }
            return;
        }
        if (isPalindrome(str)) {
            List<String> a = new ArrayList<>(ans);
            a.add(str);
            solveInefficient("" + s.charAt(n), n + 1, a);
            solveInefficient(str + s.charAt(n), n + 1, new ArrayList<>(ans));
        } else {
            solveInefficient(str + s.charAt(n), n + 1, new ArrayList<>(ans));
        }
    }
}
