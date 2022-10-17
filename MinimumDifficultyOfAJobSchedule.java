import java.util.Arrays;

public class MinimumDifficultyOfAJobSchedule {
    static int dp[][];

    public static int solve(int[] arr, int d, int i) {
        if (d == 0)
            return 11000;
        if (d == 1 && i < arr.length) {
            int ans = 0;
            for (int j = i; j < arr.length; j++)
                ans = Math.max(ans, arr[j]);
            return ans;
        }
        if (i == arr.length)
            return 11000;
        if (dp[d][i] != -1)
            return dp[d][i];
        int ans = 11000;
        int min = arr[i];
        for (int j = i; j < arr.length; j++) {
            min = Math.max(min, arr[j]);
            ans = Math.min(ans, min + solve(arr, d - 1, j + 1));
        }
        return dp[d][i] = ans;
    }

    public int minDifficultyMemoization(int[] arr, int d) {
        dp = new int[11][301];
        for (int i = 0; i < 11; i++)
            Arrays.fill(dp[i], -1);
        int ans = solve(arr, d, 0);
        if (ans == 11000)
            return -1;
        return ans;
    }

    public int minDifficultyTopDown(int[] arr, int d) {
        int n = arr.length;
        int[][] dp = new int[d + 1][n + 1];
        for (int dd = 0; dd <= d; dd++) {
            for (int i = n; i >= 0; i--) {
                if (dd == 0 || i == n) {
                    dp[dd][i] = 11000;
                    continue;
                }
                if (dd == 1 && i < n) {
                    for (int j = i; j < n; j++)
                        dp[dd][i] = Math.max(dp[dd][i], arr[j]);
                    continue;
                }
                int min = arr[i];
                dp[dd][i] = 11000;
                for (int j = i; j < n; j++) {
                    min = Math.max(min, arr[j]);
                    dp[dd][i] = Math.min(dp[dd][i], min + dp[dd - 1][j + 1]);
                }
            }
        }
        return dp[d][0] == 11000 ? -1 : dp[d][0];
    }
}