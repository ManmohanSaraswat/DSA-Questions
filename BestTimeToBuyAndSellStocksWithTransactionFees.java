import java.util.Arrays;

public class BestTimeToBuyAndSellStocksWithTransactionFees {
    static int dp[][];

    public static int solve(int[] prices, int fee, int i, boolean bought) {
        if (i == prices.length)
            return 0;
        if (dp[i][bought ? 1 : 0] != -1)
            return dp[i][bought ? 1 : 0];
        if (bought) {
            int a = solve(prices, fee, i + 1, true);
            int b = prices[i] - fee + solve(prices, fee, i + 1, false);
            return dp[i][1] = Math.max(a, b);
        } else {
            int a = solve(prices, fee, i + 1, true) - prices[i];
            int b = solve(prices, fee, i + 1, false);
            return dp[i][0] = Math.max(a, b);
        }
    }

    public int maxProfitMemoize(int[] prices, int fee) {
        dp = new int[prices.length + 1][2];
        for (int i = 0; i <= prices.length; i++)
            Arrays.fill(dp[i], -1);
        return solve(prices, fee, 0, false);
    }

    public int maxProfitTabularTopDown(int[] prices, int fee) {
        dp = new int[prices.length + 1][2];
        for (int i = prices.length - 1; i >= 0; i--) {
            dp[i][1] = Math.max(dp[i + 1][1], dp[i + 1][0] + prices[i] - fee);
            dp[i][0] = Math.max(dp[i + 1][0], dp[i + 1][1] - prices[i]);
        }
        return dp[0][0];
    }

    public int maxProfitTabularBottomUp(int[] prices, int fee) {
        dp = new int[prices.length + 1][2];
        dp[0][1] = -prices[0] - fee;
        for (int i = 1; i <= prices.length; i++) {
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i - 1] - fee);
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i - 1]);
        }
        return dp[prices.length][0];
    }
        public int maxProfitSmartPlay(int[] prices, int fee) {
            int buyDay = 0, clearDay = 0, prevBuyDay = -prices[0], prevClearDay = 0;
            for(int i = 1; i < prices.length; i++){
                buyDay = Math.max(prevBuyDay, prevClearDay - prices[i]);
                clearDay = Math.max(prevClearDay, prices[i] + prevBuyDay - fee);
                prevBuyDay = buyDay;
                prevClearDay = clearDay;
            }
            return clearDay;
        }
}
