import java.util.*;

public class MinimumCosttoSplitanArray {
    int[] dp;

    private int solve(int[] nums, int k, int n) {
        if (n == nums.length)
            return 0;
        if (dp[n] != -1)
            return dp[n];
        Map<Integer, Integer> map = new HashMap<>();
        int sum = k, minSum = Integer.MAX_VALUE;
        for (int i = n; i < nums.length; i++) {
            int freq = map.getOrDefault(nums[i], 0) + 1;
            map.put(nums[i], freq);
            if (freq == 2)
                sum += 2;
            else if (freq > 2)
                sum++;
            minSum = Math.min(minSum, sum + solve(nums, k, i + 1));
        }
        return dp[n] = minSum;
    }

    public int minCost(int[] nums, int k) {
        dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return solve(nums, k, 0);
    }
}
