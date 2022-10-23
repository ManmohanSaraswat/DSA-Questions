import java.util.Arrays;

public class CoinChange2 {
    int dp[][];

    public int solveUsingMemoization(int amount, int[] coins, int n) {
        if (amount == 0)
            return 1;
        if (n == coins.length || amount < 0)
            return 0;
        if (dp[amount][n] != -1)
            return dp[amount][n];
        int ans = solveUsingMemoization(amount, coins, n + 1);
        for (int i = coins[n]; amount - i >= 0; i += coins[n]) {
            ans += solveUsingMemoization(amount - i, coins, n + 1);
        }
        return dp[amount][n] = ans;

    }

    public int changeUsingMemoization(int amount, int[] coins) {
        dp = new int[amount + 1][coins.length + 1];
        for (int[] i : dp)
            Arrays.fill(i, -1);
        return solveUsingMemoization(amount, coins, 0);
    }

    public int changeUsing2dDp(int amounts, int[] coins) {
        dp = new int[amounts + 1][coins.length + 1];
        for (int i = 0; i <= coins.length; i++) {
            for (int amount = 0; amount <= amounts; amount++) {
                if (amount == 0) {
                    dp[amount][i] = 1;
                    continue;
                }
                if (i == 0) {
                    continue;
                }
                int coin = coins[i - 1];
                dp[amount][i] = dp[amount][i - 1];
                for (int j = coin; amount - j >= 0; j += coin) {
                    dp[amount][i] += dp[amount - j][i - 1];
                }
            }
        }
        return dp[amounts][coins.length];
    }

    int dp1D[];

    public int changeUsing1dDp(int amount, int[] coins) {
        dp1D = new int[amount + 1];
        dp1D[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i] >= 0)
                    dp1D[j] += dp1D[j - coins[i]];
            }
        }
        return dp1D[amount];
    }
}
