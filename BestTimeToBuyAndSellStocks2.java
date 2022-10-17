public class BestTimeToBuyAndSellStocks2 {
    static int dp[];
    public int find(int []prices, int currentHoldings, int i){
        if(i == prices.length) return 0;
        if(dp[i] != -1) return dp[i];
        int a = 0, b = 0, c = 0;
        a = find(prices, prices[i], i+1);
        if(currentHoldings >= 0)
            b = prices[i] - currentHoldings + find(prices, -1, i+1);
        c = find(prices, currentHoldings, i+1);
        return dp[i] = Math.max(a, Math.max(b, c));
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        dp = new int[n];
        for(int i = 0; i < n; i++)
            dp[i] = -1;
        return find(prices, -1, 0);
        // int max = 0;
        // for(int i = 1; i < n; i++){
        //     max = max + Math.max(0, prices[i] - prices[i-1]);
        // }
        // return max;
    }
}
