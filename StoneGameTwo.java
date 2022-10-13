public class StoneGameTwo {
    static int dp[][][];

    public int solve(int[] piles, int m, int currentPile, boolean alice) {
        int ans = 0;
        if (currentPile + m * 2 >= piles.length) {
            if (!alice)
                return 0;
            for (int i = currentPile; i < piles.length; i++)
                ans += piles[i];
            return ans;
        }
        if (dp[currentPile][m][alice ? 1 : 0] != -1)
            return dp[currentPile][m][alice ? 1 : 0];
        
        if(alice){
            int res = Integer.MIN_VALUE;
            for (int i = 1; i <= 2 * m; i++) {
                if (alice)
                    ans += piles[currentPile + i - 1];
                res = Math.max(res, ans + solve(piles, Math.max(m, i), currentPile + i, !alice));
            }
            return dp[currentPile][m][alice ? 1 : 0] = res;
        }else{
            int res = Integer.MAX_VALUE;
            for (int i = 1; i <= 2 * m; i++) {
                res = Math.min(res, solve(piles, Math.max(m, i), currentPile + i, !alice));
            }
            return dp[currentPile][m][alice ? 1 : 0] = res;
        }
    }

    public int stoneGameII(int[] piles) {
        dp = new int[101][101][2];
        for (int i = 0; i <= 100; i++) {
            for (int j = 0; j <= 100; j++)
                dp[i][j][0] = dp[i][j][1] = -1;
        }
        return solve(piles, 1, 0, true);
    }
}
