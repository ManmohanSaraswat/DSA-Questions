import java.util.stream.IntStream;

public class PartitionEqualSubsetSum {
    Boolean[][] dp;

    private boolean solve(int[] nums, int n, int curSum) {
        if (n == nums.length) {
            if (curSum == 0)
                return true;
            return false;
        }
        if (curSum < 0)
            return false;
        if (dp[n][curSum] != null)
            return dp[n][curSum];
        return dp[n][curSum] = solve(nums, n + 1, curSum - nums[n]) || solve(nums, n + 1, curSum);
    }

    public boolean canPartition(int[] nums) {
        int sum = IntStream.of(nums).sum();
        dp = new Boolean[nums.length][sum + 1];
        if (sum % 2 != 0)
            return false;
        return solve(nums, 0, sum / 2);
    }

    public boolean canPartitionEfficient(int[] nums) {
        int sum = IntStream.of(nums).sum();
        dp = new Boolean[nums.length][sum + 1];
        if (sum % 2 != 0)
            return false;
        int curSum = sum / 2;
        for (int i = 0; i < nums.length; i++) {
            for (int j = curSum; j >= 0; j++) {
                dp[i][j] = dp[i - 1][curSum - nums[i]] || dp[i - 1][curSum];
            }
        }
        return dp[nums.length - 1][curSum];
    }

    public boolean canPartitionMostEfficient(int[] nums) {
        int sum = IntStream.of(nums).sum();
        if (sum % 2 != 0)
            return false;
        int curSum = sum / 2;
        boolean[] dp = new boolean[curSum + 1];
        dp[0] = true;
        for (int i : nums) {
            for (int j = curSum; j >= 0; j--) {
                if (j >= i) {
                    dp[j] = dp[j - i] || dp[j];
                }
            }
        }
        return dp[curSum];
    }
}
