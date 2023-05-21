public class MaximumNumberofMovesinaGrid {
    int dirs[][] = new int[][] { { -1, 1 }, { 0, 1 }, { 1, 1 } };
    Integer[][] dp;

    private int solve(int[][] grid, int n, int m, int N, int M) {
        if (dp[n][m] != null)
            return dp[n][m];
        int max = 0;
        for (int[] dir : dirs) {
            int x = dir[0] + n, y = dir[1] + m;
            if (x < 0 || x == N || y < 0 || y == M)
                continue;
            if (grid[n][m] < grid[x][y])
                max = Math.max(max, 1 + solve(grid, x, y, N, M));
        }
        return dp[n][m] = max;
    }

    public int maxMoves(int[][] grid) {
        int max = 0;
        dp = new Integer[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            max = Math.max(max, solve(grid, i, 0, grid.length, grid[0].length));
        }
        return max;
    }
}
