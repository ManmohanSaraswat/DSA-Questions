import java.util.HashMap;
import java.util.Map;

public class SellingPiecesofWood {
    Long[][] dp;

    class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    Map<Pair, Integer> map;

    private long solve(int n, int m) {
        if (n == 0 || m == 0)
            return 0;
        if (dp[n][m] != null)
            return dp[n][m];
        long res = map.getOrDefault(new Pair(n, m), 0);
        for (int i = 1; i < n; i++)
            res = Math.max(res, solve(i, m) + solve(n - i, m));
        for (int i = 1; i < m; i++)
            res = Math.max(res, solve(n, i) + solve(n, m - i));
        dp[n][m] = res;
        return res;
    }

    public long sellingWood(int m, int n, int[][] prices) {
        dp = new Long[m + 1][n + 1];
        map = new HashMap<>();
        for (int[] p : prices)
            map.put(new Pair(p[0], p[1]), p[2]);
        return solve(m, n);
    }
}
