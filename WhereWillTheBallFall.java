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
}
