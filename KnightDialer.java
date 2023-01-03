import java.util.Arrays;

public class KnightDialer {
    int[][] dirs = new int[][] {
            { -2, -1 }, { -2, 1 }, { -1, -2 }, { 1, -2 }, { -1, 2 }, { 1, 2 }, { 2, -1 }, { 2, 1 }
    };
    int mod = 1000000007;
    int[][][] dp;

    private int dfs(int[][] board, int n, int i, int j) {
        if (n == 0)
            return 1;
        int res = 0;
        if (dp[n][i][j] != -1)
            return dp[n][i][j];
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x < 0 || y < 0 || x >= 4 || y >= 3)
                continue;
            if (x == 3 && (y == 0 || y == 2))
                continue;
            res = (res + dfs(board, n - 1, x, y)) % mod;
        }
        return dp[n][i][j] = res;
    }

    private int solve(int[][] board, int n) {
        int res = 0;
        dp = new int[n][4][3];
        for (int i[][] : dp)
            for (int j[] : i)
                Arrays.fill(j, -1);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                res = (res + dfs(board, n - 1, i, j)) % mod;
            }
        }
        res = (res + dfs(board, n - 1, 3, 1)) % mod;
        return res;
    }

    public int knightDialer(int n) {
        int[][] board = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { -1, 0, -1 } };
        return solve(board, n);
    }
}