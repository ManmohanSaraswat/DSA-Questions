public class SolvingQuestionWithBrainpower {
    Long[] dp;

    private long solve(int[][] arr, int n) {
        if (n >= arr.length)
            return 0;
        if (dp[n] != null)
            return dp[n];
        return dp[n] = Math.max(solve(arr, n + 1), arr[n][0] + solve(arr, n + arr[n][1] + 1));
    }

    public long mostPoints(int[][] questions) {
        dp = new Long[questions.length];
        return solve(questions, 0);
    }
}
