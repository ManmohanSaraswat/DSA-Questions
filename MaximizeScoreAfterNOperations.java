public class MaximizeScoreAfterNOperations {
    private int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    Integer[][] dp;

    private int solve(int[] nums, int n, int bit) {
        if (2 * n == nums.length)
            return 0;
        if (dp[bit][n] != null)
            return dp[bit][n];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (((1 << i) & bit) != 0)
                continue;
            for (int j = i + 1; j < nums.length; j++) {
                if (((1 << j) & bit) != 0)
                    continue;
                max = Math.max(max, (n + 1) * gcd(nums[i], nums[j]) + solve(nums, n + 1, bit | (1 << i) | (1 << j)));
            }
        }
        return dp[bit][n] = max;
    }

    public int maxScore(int[] nums) {
        dp = new Integer[1 << 14 + 1][nums.length / 2];
        return solve(nums, 0, 0);
    }
}
