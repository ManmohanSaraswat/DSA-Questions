public class CheckifThereIsaValidParenthesesStringPath {
    Boolean[][][] dp;

    private boolean solve(char[][] grid, int i, int j, int path) {
        if (i == grid.length || j == grid[0].length)
            return false;
        path += (grid[i][j] == '(' ? 1 : -1);
        if (i == grid.length - 1 && j == grid[0].length - 1)
            return path == 0;
        if (path < 0)
            return false;
        if (dp[i][j][path] != null)
            return dp[i][j][path];
        return dp[i][j][path] = solve(grid, i + 1, j, path) || solve(grid, i, j + 1, path);
    }

    public boolean hasValidPath(char[][] grid) {
        dp = new Boolean[grid.length][grid[0].length][210];
        return solve(grid, 0, 0, 0);
    }
}
