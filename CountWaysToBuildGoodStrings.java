public class CountWaysToBuildGoodStrings {
    Integer[] dp;
    int mod = 1000000007;

    private int solve(int low, int high, int zero, int one, int n) {
        if (n > high)
            return 0;
        if (dp[n] != null)
            return dp[n];
        int res = 0;
        if (n >= low && n <= high)
            res = 1;
        int cntZeros = solve(low, high, zero, one, n + zero);
        int cntOnes = solve(low, high, zero, one, n + one);
        return dp[n] = (cntZeros + cntOnes + res) % mod;
    }

    public int countGoodStrings(int low, int high, int zero, int one) {
        dp = new Integer[100001];
        return solve(low, high, zero, one, 0);
    }
}
