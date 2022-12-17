import java.util.Arrays;

public class BestTimetoBuyandSellStockIII {
    private static int[][][] dp;

    private static int solve(int[] prices, int n, int holdings, int completedTransactions) {
        if (n == prices.length)
            return 0;
        if (completedTransactions == 2)
            return 0;
        if (dp[n][holdings][completedTransactions] != -1)
            return dp[n][holdings][completedTransactions];
        if (holdings == 1) {
            int a = solve(prices, n + 1, 1, completedTransactions);
            int b = prices[n] + solve(prices, n + 1, 0, completedTransactions + 1);
            return dp[n][holdings][completedTransactions] = Math.max(a, b);
        } else {
            int a = solve(prices, n + 1, 0, completedTransactions);
            int b = solve(prices, n + 1, 1, completedTransactions) - prices[n];
            return dp[n][holdings][completedTransactions] = Math.max(a, b);
        }
    }

    public int maxProfit(int[] prices) {
        dp = new int[prices.length + 1][2][2];
        for (int[][] i : dp)
            for (int[] j : i)
                Arrays.fill(j, -1);
        return solve(prices, 0, 0, 0);
    }
}
