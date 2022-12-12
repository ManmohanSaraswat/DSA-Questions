public class ClimbingStairs {
    private static int[] dp;
    private static int solve(int n){
        if(n < 0) return 0;
        if(n == 0){
            return 1;
        }
        if(dp[n] != 0) return dp[n];
        return dp[n] = solve(n - 1) + solve(n - 2);
    }
    public int climbStairs(int n) {
        dp = new int[n + 1];
        return solve(n);
    }
}
