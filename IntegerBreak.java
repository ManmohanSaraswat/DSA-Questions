import java.util.Arrays;

public class IntegerBreak {
    static int[] dp;

    private int solve(int n) {
        if (n <= 2)
            return 1;
        if (dp[n] != -1)
            return dp[n];
        int max = 0;
        for (int i = 1; i < n; i++) {
            int temp = Math.max(i * (n - i), i * solve(n - i));
            max = Math.max(temp, max);
        }
        return dp[n] = max;
    }

    public int integerBreakMemoization(int n) {
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return solve(n);
    }

    public int integerBreak(int n) {
        int dp[] = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }
}
