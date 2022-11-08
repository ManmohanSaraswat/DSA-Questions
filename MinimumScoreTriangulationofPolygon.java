import java.util.Arrays;

public class MinimumScoreTriangulationofPolygon {
    int[][] dp;

    private int solve(int[] values, int start, int end) {
        if (end - start == 2)
            return values[start] * values[end] * values[start + 1];
        if (end - start < 2)
            return 0;
        if (dp[start][end] != -1)
            return dp[start][end];
        int min = Integer.MAX_VALUE;
        for (int i = start + 1; i < end; i++) {
            int ans = values[start] * values[end] * values[i] + solve(values, start, i) + solve(values, i, end);
            min = Math.min(min, ans);
        }
        return dp[start][end] = min;
    }

    public int minScoreTriangulation(int[] values) {
        dp = new int[values.length][values.length];
        for (int[] i : dp)
            Arrays.fill(i, -1);
        return solve(values, 0, values.length - 1);
    }
}
