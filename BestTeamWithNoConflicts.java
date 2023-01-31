import java.util.Arrays;

public class BestTeamWithNoConflicts {
    int[][] dp;

    private int solve(int[][] arr, int n, int prev) {
        if (n == arr.length)
            return 0;
        if (dp[n][prev + 1] != -1)
            return dp[n][prev + 1];
        if (prev == -1) {
            return dp[n][prev + 1] = Math.max(arr[n][0] + solve(arr, n + 1, n), solve(arr, n + 1, prev));
        }
        if (arr[prev][0] > arr[n][0]) {
            return dp[n][prev + 1] = solve(arr, n + 1, prev);
        }
        return dp[n][prev + 1] = Math.max(arr[n][0] + solve(arr, n + 1, n), solve(arr, n + 1, prev));
    }

    public int bestTeamScore(int[] scores, int[] ages) {
        int[][] arr = new int[scores.length][2];
        dp = new int[scores.length][scores.length + 1];
        for (int[] i : dp)
            Arrays.fill(i, -1);
        for (int i = 0; i < scores.length; i++) {
            arr[i][0] = scores[i];
            arr[i][1] = ages[i];
        }
        Arrays.sort(arr, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        return solve(arr, 0, -1);
    }

    public int bestTeamScoreEfficient(int[] scores, int[] ages) {
        int[][] arr = new int[scores.length][];
        int[] dp = new int[scores.length + 1];
        for (int i = 0; i < scores.length; i++)
            arr[i] = new int[] { scores[i], ages[i] };
        Arrays.sort(arr, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            dp[i] = arr[i][0];
            for (int j = 0; j < i; j++) {
                if (arr[i][0] >= arr[j][0])
                    dp[i] = Math.max(dp[i], dp[j] + arr[i][0]);
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
