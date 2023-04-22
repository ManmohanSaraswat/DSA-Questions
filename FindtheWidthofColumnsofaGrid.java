public class FindtheWidthofColumnsofaGrid {
    private int solve(int n) {
        if (n == 0)
            return 1;
        int res = 0;
        if (n < 0) {
            res = 1;
            n = -1 * n;
        }
        while (n > 0) {
            res++;
            n /= 10;
        }
        return res;
    }

    public int[] findColumnWidth(int[][] grid) {
        int res[] = new int[grid[0].length];
        for (int j = 0; j < grid[0].length; j++) {
            for (int i = 0; i < grid.length; i++) {
                res[j] = Math.max(res[j], solve(grid[i][j]));
            }
        }
        return res;
    }
}
