public class UniquePaths {
    private int solve(int m, int n){
        if(m == 1 && n == 1) return 1;
        else if(m < 1 || n < 1) return 0;
        else{
            return solve(m-1, n) + solve(m, n-1);
        }
    }
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m+1][n+1];
        dp[1][1] = 1;
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                dp[i][j] += dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m][n];
    }
}
