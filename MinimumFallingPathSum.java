public class MinimumFallingPathSum {
    static int dp[][];

    public int find(int[][] matrix, int i, int j) {
        if (j < 0 || j == matrix.length)
            return Integer.MAX_VALUE;
        if (i == matrix.length - 1)
            return matrix[i][j];
        if (dp[i][j] != -1)
            return dp[i][j];
        return dp[i][j] = matrix[i][j]
                + Math.min(find(matrix, i + 1, j), Math.min(find(matrix, i + 1, j - 1), find(matrix, i + 1, j + 1)));
    }

    public int minFallingPathSum(int[][] matrix) {
        dp = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix.length; j++)
                dp[i][j] = -1;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < matrix.length; i++)
            ans = Math.min(ans, find(matrix, 0, i));
        return ans;
    }
}
