import java.util.Arrays;

public class MinimumFallingPathSumHardDp {
    static int dp[][];

    public static int find(int [][] grid, int i, int j){
        if(i == grid.length) return 0;
        if(dp[i][j] != 20000) return dp[i][j];
        int minSum = Integer.MAX_VALUE;
        for(int x = 0; x < grid.length; x++){
            if(x != j){
                minSum = Math.min(minSum, grid[i][x] + find(grid, i+1, x));
            }
        }
        return dp[i][j] = minSum;
    }
    public static int minFallingPathSum(int[][] grid) {
        dp = new int[grid.length][grid.length];
        int minSum = Integer.MAX_VALUE;
        for(int i = 0; i < grid.length; i++) Arrays.fill(dp[i], 20000);
        for(int i = 0; i < grid.length; i++)
            minSum = Math.min(minSum, grid[0][i] + find(grid, 1, i));
        return minSum;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][] { { -73, 61, 43, -48, -36 },
                { 3, 30, 27, 57, 10 },
                { 96, -76, 84, 59, -15 },
                { 5, -49, 76, 31, -7 }, 
                { 97, 91, 61, -46, 67 } };
        System.out.println(minFallingPathSum(arr));
    }
}