import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsofaPhoneNumber {
    char arr[][] = new char[][] { { 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g', 'h', 'i' }, { 'j', 'k', 'l' },
            { 'm', 'n', 'o' },
            { 'p', 'q', 'r', 's' }, { 't', 'u', 'v' }, { 'w', 'x', 'y', 'z' } };
    List<String> res;

    private void solve(char[] brr, int n, String str) {
        if (n == brr.length) {
            res.add(str);
            return;
        }
        for (char ch : arr[brr[n] - '2']) {
            solve(brr, n + 1, str + ch);
        }
    }

    public List<String> letterCombinations(String digits) {
        char[] brr = digits.toCharArray();
        res = new ArrayList<>();
        if (brr.length == 0)
            return res;
        solve(brr, 0, "");
        return res;
    }
}
