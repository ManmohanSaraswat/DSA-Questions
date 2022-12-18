import java.util.Arrays;

public class LastStoneWeightII {
    private static int[][] dp;

    private static int solve(int[] stones, int target, int index) {
        if (index == stones.length || target < 0)
            return 0;
        if (dp[index][target] != -1)
            return dp[index][target];
        int a = solve(stones, target, index + 1);
        if (target >= stones[index]) {
            int b = solve(stones, target - stones[index], index + 1) + stones[index];
            return dp[index][target] = Math.max(a, b);
        }
        return dp[index][target] = a;
    }

    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int i = 0; i < stones.length; i++)
            sum += stones[i];
        dp = new int[stones.length + 1][sum];
        for (int[] i : dp)
            Arrays.fill(i, -1);
        int a = solve(stones, sum / 2, 0);
        int b = sum - a;
        return Math.abs(a - b);
    }
}
