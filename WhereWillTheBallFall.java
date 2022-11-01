import java.util.Arrays;

public class WhereWillTheBallFall {
    static int dp[][];
    public static int find(int [][] grid, int i, int j){
        if(i == grid.length) return j;
        if(j == 0 && grid[i][j] == -1) return -1;
        if(j == grid[i].length-1 && grid[i][j] == 1) return -1;
        if(grid[i][j] == 1 && grid[i][j+1] == -1) return -1;
        if(grid[i][j] == -1 && grid[i][j-1] == 1) return -1;
        if(dp[i][j] != 101) return dp[i][j];
        if(grid[i][j] == -1)
            return dp[i][j] = find(grid, i+1, j-1);
        else
            return dp[i][j] = find(grid, i+1, j+1);
    }
    public int[] findBall(int[][] grid) {
        int []arr = new int[grid[0].length];
        dp = new int[101][101];
        for(int i = 0; i < 101; i++) Arrays.fill(dp[i], 101);
        for(int i = 0; i < arr.length; i++){
            arr[i] = find(grid, 0, i);
        }
        return arr;
    }

    private int solveOptimized(int[][] grid, int i, int j, int n, int m) {
        if (i == n) return j;
        if (i < 0 || j < 0 || j == m) return -1;
        if (grid[i][j] == 1) {
            if (j + 1 == m || (j + 1 < m && grid[i][j + 1] == -1)) return -1;
            return solveOptimized(grid, i + 1, j + 1, n, m);
        } else {
            if (j - 1 == -1 || (j - 1 >= 0 && grid[i][j - 1] == 1)) return -1;
            return solveOptimized(grid, i + 1, j - 1, n, m);
        }
    }

    public int[] findBallOptimized(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[] res = new int[m];
        for (int i = 0; i < m; i++)
            res[i] = solveOptimized(grid, 0, i, n, m);
        return res;
    }
}
