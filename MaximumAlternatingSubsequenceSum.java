import java.util.Arrays;

public class MaximumAlternatingSubsequenceSum {
    long[][] dp;

    private long solve(int[] nums, int n, int lastWasEven) {
        if (n == nums.length)
            return 0;
        if (dp[n][lastWasEven] != -1)
            return dp[n][lastWasEven];
        if (lastWasEven == 1) {
            long a = solve(nums, n + 1, 0) - nums[n];
            long b = solve(nums, n + 1, 1);
            return dp[n][1] = Math.max(a, b);
        } else {
            long a = solve(nums, n + 1, 1) + nums[n];
            long b = solve(nums, n + 1, 0);
            return dp[n][0] = Math.max(a, b);
        }
    }

    public long maxAlternatingSum(int[] nums) {
        dp = new long[nums.length + 1][2];
        for (long[] i : dp)
            Arrays.fill(i, -1);
        return Math.max(solve(nums, 0, 0), solve(nums, 0, 1));
    }

    public long maxAlternatingSumTabular(int[] nums) {
        dp = new long[nums.length + 1][2];
        int n = nums.length;
        for (int i = 1; i <= nums.length; i++) {
            long a = dp[i - 1][0] - nums[i - 1];
            long b = dp[i - 1][1];
            dp[i][1] = Math.max(a, b);
            a = dp[i - 1][1] + nums[i - 1];
            b = dp[i - 1][0];
            dp[i][0] = Math.max(a, b);
        }
        return Math.max(dp[n][0], dp[n][1]);
    }

    public long maxAlternatingSumWithoutDp(int[] nums) {
        long even = 0, odd = 0, prevOdd = 0, prevEven = 0;
        for (int i = 0; i < nums.length; i++) {
            even = Math.max(odd - nums[i], prevEven);
            odd = Math.max(even + nums[i], prevOdd);
            prevEven = even;
            prevOdd = odd;
        }
        return Math.max(odd, even);
    }
}