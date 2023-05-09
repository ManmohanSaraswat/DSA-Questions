public class NumberofClosedIslands {
    int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    private boolean solve(int i, int j, int[][] grid) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length)
            return false;
        if (grid[i][j] == 1)
            return true;
        grid[i][j] = 1;
        boolean res = true;
        for (int dir[] : dirs) {
            int x = i + dir[0], y = j + dir[1];
            res = solve(x, y, grid) && res;
        }
        return res;
    }

    public int closedIsland(int[][] grid) {
        int count = 0, n = grid.length, m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0 && solve(i, j, grid))
                    count++;
            }
        }
        return count;
    }
}
