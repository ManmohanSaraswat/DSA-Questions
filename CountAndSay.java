public class CountAndSay {
    public String makeString(String str) {
        int count = 1, n = str.length();
        StringBuilder res = new StringBuilder();
        for (int i = 1; i < n; i++) {
            if (str.charAt(i - 1) == str.charAt(i))
                count++;
            else {
                res.append("" + count + str.charAt(i - 1));
                count = 1;
            }
        }
        res.append("" + count + str.charAt(n - 1));
        return res.toString();
    }

    public String countAndSay(int n) {
        String res = "1";
        for (int i = 2; i <= n; i++) {
            res = makeString(res);
        }
        return res;
    }
}