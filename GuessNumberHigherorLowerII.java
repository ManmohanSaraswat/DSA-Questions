import java.util.Arrays;

public class GuessNumberHigherorLowerII {
    public int getMoneyAmountEfficient(int n) {
        int[][] dp = new int[n + 2][n + 2];
        for (int start = n; start >= 1; start--) {
            for (int end = 1; end <= n; end++) {
                if (start >= end)
                    continue;
                dp[start][end] = Integer.MAX_VALUE;
                for (int k = start; k <= end; k++) {
                    dp[start][end] = Math.min(dp[start][end], k + Math.max(dp[start][k - 1], dp[k + 1][end]));
                }
            }
        }
        return dp[1][n];
    }

    int dp[][];

    private int solve(int start, int end) {
        if (start >= end)
            return 0;
        if (dp[start][end] != -1)
            return dp[start][end];
        int res = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            res = Math.min(res, i + Math.max(solve(start, i - 1), solve(i + 1, end)));
        }
        return dp[start][end] = res;
    }

    public int getMoneyAmount(int n) {
        dp = new int[n + 1][n + 1];
        for (int i[] : dp)
            Arrays.fill(i, -1);
        return solve(1, n);
    }
}
