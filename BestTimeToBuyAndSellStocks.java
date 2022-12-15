public class BestTimeToBuyAndSellStocks {
    public int maxProfit(int[] prices) {
        int buy = prices[0], profit = Integer.MIN_VALUE;
        for(int i = 0; i < prices.length; i++){
            if(buy > prices[i])
                buy = prices[i];
            profit = Math.max(profit, prices[i] - buy);
        }
        return profit;
    }
}
