public class MaximumNumberofFishinaGrid {
    int[][] dirs = new int[][] { { 0, -1 }, { 0, 1 }, { 1, 0 }, { -1, 0 } };

    private int dfs(int n, int m, int[][] grid, boolean[][] visited) {
        int res = grid[n][m];
        visited[n][m] = true;
        for (int dir[] : dirs) {
            int x = dir[0] + n, y = dir[1] + m;
            if (x < 0 || y < 0 || x == grid.length || y == grid[0].length || visited[x][y] || grid[x][y] == 0)
                continue;
            res += dfs(x, y, grid, visited);
        }
        return res;
    }

    public int findMaxFish(int[][] grid) {
        int res = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (visited[i][j] || grid[i][j] == 0)
                    continue;
                res = Math.max(res, dfs(i, j, grid, visited));
            }
        }
        return res;
    }
}
