import java.util.Arrays;

public class MinimumASCIIDeleteSumOfTwoStrings {
    static int[][] dp;

    private int solve(String s1, String s2, int n, int m) {
        if (s1.length() == n || s2.length() == m) {
            int ans = 0;
            if (s1.length() > n) {
                for (int i = n; i < s1.length(); i++)
                    ans += s1.charAt(i);
            }
            if (s2.length() > m) {
                for (int i = m; i < s2.length(); i++)
                    ans += s2.charAt(i);
            }
            return ans;
        }
        if (dp[n][m] != -1)
            return dp[n][m];
        int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE, c = Integer.MAX_VALUE;
        if (s1.charAt(n) == s2.charAt(m)) {
            a = Math.min(a, solve(s1, s2, n + 1, m + 1));
        }
        b = Math.min(b, s1.charAt(n) + solve(s1, s2, n + 1, m));
        c = Math.min(c, s2.charAt(m) + solve(s1, s2, n, m + 1));
        return dp[n][m] = Math.min(a, Math.min(b, c));
    }

    public int minimumDeleteSum(String s1, String s2) {
        dp = new int[s1.length() + 1][s2.length() + 1];
        for (int[] i : dp)
            Arrays.fill(i, -1);
        return solve(s1, s2, 0, 0);
    }

    public int minimumDeleteSumDpTabular(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        dp = new int[n + 1][m + 1];
        for (int i = 1; i <= m; i++)
            dp[0][i] = dp[0][i - 1] + s2.charAt(i - 1);
        for (int i = 1; i <= n; i++) {
            dp[i][0] = dp[i - 1][0] + s1.charAt(i - 1);
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(s1.charAt(i - 1) + dp[i - 1][j], s2.charAt(j - 1) + dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];
    }
}