import java.util.Arrays;
import java.util.List;

public class Triangle {
    public int minimumTotalSpaceOptimizedDP(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n + 1];
        for (int row = n - 1; row >= 0; row--) {
            int m = triangle.get(row).size();
            for (int col = 0; col < m; col++) {
                if (row == n - 1) {
                    dp[col] = triangle.get(row).get(col);
                    continue;
                }
                dp[col] = triangle.get(row).get(col) + Math.min(dp[col], dp[col + 1]);
            }
        }
        return dp[0];
    }

    public int minimumTotal2dDp(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size() + 1][triangle.size() + 1];
        for (int row = triangle.size() - 1; row >= 0; row--) {
            for (int col = 0; col < triangle.get(row).size(); col++) {
                if (row == triangle.size() - 1) {
                    dp[row][col] = triangle.get(row).get(col);
                    continue;
                }
                dp[row][col] = triangle.get(row).get(col) + Math.min(dp[row + 1][col], dp[row + 1][col + 1]);
            }
        }
        return dp[0][0];
    }

    int[][] dp;

    private int solve(List<List<Integer>> triangle, int row, int col) {
        if (row == triangle.size())
            return 0;
        if (dp[row][col] != -1)
            return dp[row][col];
        int a = 0, b = 0;
        a = solve(triangle, row + 1, col);
        if (row + 1 < triangle.size() && triangle.get(row + 1).size() > col + 1)
            ;
        b = solve(triangle, row + 1, col + 1);
        return dp[row][col] = triangle.get(row).get(col) + Math.min(a, b);
    }

    public int minimumTotalMemoized(List<List<Integer>> triangle) {
        dp = new int[200][200];
        for (int[] i : dp)
            Arrays.fill(i, -1);
        return solve(triangle, 0, 0);
    }
}