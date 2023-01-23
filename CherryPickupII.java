import java.util.Arrays;

public class CherryPickupII {
    int[] dirs = new int[] { -1, 0, 1 };
    int dp[][][];

    private int solve(int[][] grid, int i, int j1, int j2) {
        int ans = 0, res = 0;
        if (i == grid.length)
            return 0;
        if (dp[i][j1][j2] != -1)
            return dp[i][j1][j2];
        if (j1 != j2)
            ans = grid[i][j1] + grid[i][j2];
        else
            ans = grid[i][j1];
        for (int j : dirs) {
            int nextJ1 = j1 + j;
            for (int k : dirs) {
                int nextJ2 = j2 + k;
                if (nextJ1 < 0 || nextJ1 == grid[0].length || nextJ2 < 0 || nextJ2 == grid[0].length)
                    continue;
                res = Math.max(res, ans + solve(grid, i + 1, nextJ1, nextJ2));
            }
        }
        return dp[i][j1][j2] = res;
    }

    public int cherryPickup(int[][] grid) {
        dp = new int[grid.length][grid[0].length][grid[0].length];
        for (int i[][] : dp)
            for (int j[] : i)
                Arrays.fill(j, -1);
        return solve(grid, 0, 0, grid[0].length - 1);
    }
}
