public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int res = 0, dp[][] = new int[2][matrix[0].length + 1];
        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 1; j <= matrix[0].length; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[1][j] = 1 + Math.min(dp[0][j], Math.min(dp[1][j - 1], dp[0][j - 1]));
                    res = Math.max(res, dp[1][j]);
                }
            }
            for (int j = 1; j <= matrix[0].length; j++) {
                dp[0][j] = dp[1][j];
                dp[1][j] = 0;
            }
        }
        return res * res;
    }
}
