public class BestTimetoBuyandSellStockwithCooldown {
    private static int[][] dp;

    private static int solve(int[] prices, int n, boolean holdings) {
        if (n >= prices.length)
            return 0;
        if (dp[n][holdings ? 1 : 0] != -1)
            return dp[n][holdings ? 1 : 0];
        if (holdings) {
            int a = solve(prices, n + 1, true);
            int b = prices[n] + solve(prices, n + 2, false);
            return dp[n][1] = Math.max(a, b);
        } else {
            int a = solve(prices, n + 1, true) - prices[n];
            int b = solve(prices, n + 1, false);
            return dp[n][0] = Math.max(a, b);
        }

    }

    public int maxProfit(int[] prices) {
        dp = new int[prices.length][2];
        for (int[] i : dp)
            i[0] = i[1] = -1;
        return solve(prices, 0, false);
    }

    public int maxProfitSmartTrick(int[] prices) {
        int buyDay = 0, sellDay = 0, coolDownDay = 0;
        int prevBuyDay = -prices[0], prevSellDay = 0, prevCoolDownDay = 0;
        for (int i = 1; i < prices.length; i++) {
            buyDay = Math.max(prevBuyDay, prevCoolDownDay - prices[i]);
            sellDay = Math.max(prevSellDay, prices[i] + prevBuyDay);
            coolDownDay = prevSellDay;
            prevBuyDay = buyDay;
            prevSellDay = sellDay;
            prevCoolDownDay = coolDownDay;
        }
        return sellDay;
    }
}