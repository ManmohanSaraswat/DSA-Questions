import java.util.Arrays;

public class MinimumPathCostInAGrid {
    static int dp[][];
    public static int find(int[][] grid, int[][] moveCost, int i, int j) {
        if (i == grid.length)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        int ans = Integer.MAX_VALUE;
        for (int k = 0; k < grid[0].length; k++) {
            int toAdd = (i + 1 == grid.length) ? 0 : moveCost[grid[i][j]][k];
            ans = Math.min(ans, grid[i][j] + toAdd + find(grid, moveCost, i + 1, k));
        }
        return dp[i][j] = ans;
    }

    public int minPathCostMemoization(int[][] grid, int[][] moveCost) {
        int n = grid.length, m = grid[0].length;
        dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++)
            Arrays.fill(dp[i], -1);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < grid[0].length; i++) {
            ans = Math.min(ans, find(grid, moveCost, 0, i));
        }
        return ans;
    }
}
