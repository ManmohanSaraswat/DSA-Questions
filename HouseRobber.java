import java.util.Arrays;

public class HouseRobber {
    private static int dp[];

    private static int solve(int[] nums, int n) {
        if (n >= nums.length)
            return 0;
        if (dp[n] != -1)
            return dp[n];
        return dp[n] = Math.max(nums[n] + solve(nums, n + 2), solve(nums, n + 1));
    }

    public int rob(int[] nums) {
        dp = new int[nums.length + 1];
        Arrays.fill(dp, -1);
        return Math.max(solve(nums, 0), solve(nums, 1));
    }

    public int robTabular(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int[] dp = new int[nums.length + 1];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }
}