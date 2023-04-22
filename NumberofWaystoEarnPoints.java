public class NumberofWaystoEarnPoints {
    int mod = 1000000007;
    Integer dp[][];

    private int solve(int target, int[][] types, int n, int total) {
        if (n == types.length) {
            if (target == total)
                return 1;
            return 0;
        }
        if (dp[n][total] != null)
            return dp[n][total];
        int x = types[n][0], ans = solve(target, types, n + 1, total) % mod;
        for (int i = 1; i <= x; i++) {
            if (total + i * types[n][1] > target)
                return dp[n][total] = ans;
            ans = (ans % mod + solve(target, types, n + 1, total + i * types[n][1]) % mod) % mod;
        }
        return dp[n][total] = ans;
    }

    public int waysToReachTarget(int target, int[][] types) {
        dp = new Integer[types.length][1005];
        return solve(target, types, 0, 0);
    }
}
