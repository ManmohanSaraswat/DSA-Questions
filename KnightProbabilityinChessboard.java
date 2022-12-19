import java.util.Arrays;

public class KnightProbabilityinChessboard {
    private static int[][] dirs = new int[][] { { -2, -1 }, { -2, 1 }, { -1, -2 }, { -1, 2 }, { 1, -2 }, { 1, 2 },
            { 2, -1 }, { 2, 1 }
    };
    private static double[][][] dp;

    private static double solve(int n, int k, int row, int col) {
        if (row < 0 || col < 0 || row >= n || col >= n)
            return 0;
        if (k == 0)
            return 1;
        if (dp[k][row][col] != -1)
            return dp[k][row][col];
        double ans = 0;
        for (int[] dir : dirs) {
            int r = row + dir[0], c = col + dir[1];
            ans += solve(n, k - 1, r, c);
        }
        return dp[k][row][col] = ans;
    }

    public double knightProbability(int n, int k, int row, int column) {
        dp = new double[k + 1][n][n];
        for (double[][] i : dp)
            for (double[] j : i)
                Arrays.fill(j, -1);
        double ans = solve(n, k, row, column);
        return ans / Math.pow(8, k);
    }
}