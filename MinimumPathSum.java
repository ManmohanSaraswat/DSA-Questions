public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = Integer.MAX_VALUE;
                else if (i == 1 && j == 1)
                    dp[i][j] = grid[i - 1][j - 1];
                else
                    dp[i][j] = grid[i - 1][j - 1] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[n][m];
    }
}
