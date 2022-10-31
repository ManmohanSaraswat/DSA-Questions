import java.util.Arrays;

public class StoneGameVII {
    static int dp[][][];
    static int[] prefixSum;

    private int solve(int[] stones, int start, int end, boolean alice) {
        if (start > end)
            return 0;
        if (dp[start][end][alice ? 1 : 0] != -1)
            return dp[start][end][alice ? 1 : 0];
        if (alice) {
            int chooseFirst = 0, chooseLast = 0;
            // for(int i = start + 1; i <= end; i++) chooseFirst += stones[i];

            chooseFirst = prefixSum[end + 1] - prefixSum[start + 1];
            int a = solve(stones, start + 1, end, !alice);
            // for(int i = start; i < end; i++) chooseLast += stones[i];
            chooseLast = prefixSum[end] - prefixSum[start];
            int b = solve(stones, start, end - 1, !alice);
            return dp[start][end][alice ? 1 : 0] = Math.max(chooseFirst - a, chooseLast - b);
        } else {
            int chooseFirst = 0, chooseLast = 0;
            // for(int i = start + 1; i <= end; i++) chooseFirst += stones[i];
            chooseFirst = prefixSum[end + 1] - prefixSum[start + 1];
            int a = solve(stones, start + 1, end, !alice);
            // for(int i = start; i < end; i++) chooseLast += stones[i];
            chooseLast = prefixSum[end] - prefixSum[start];
            int b = solve(stones, start, end - 1, !alice);
            return dp[start][end][alice ? 1 : 0] = Math.max(chooseFirst - a, chooseLast - b);
        }
    }

    public int stoneGameVII(int[] stones) {
        int n = stones.length;
        dp = new int[n + 1][n + 1][2];
        prefixSum = new int[n + 1];
        prefixSum[0] = stones[0];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + stones[i - 1];
        }
        for (int[][] i : dp)
            for (int[] j : i)
                Arrays.fill(j, -1);
        return solve(stones, 0, stones.length - 1, true);
    }

    static int dp2D[][];

    private int solve2dDp(int[] stones, int start, int end) {
        if (start > end)
            return 0;
        if (dp2D[start][end] != -1)
            return dp2D[start][end];
        int chooseFirst = prefixSum[end + 1] - prefixSum[start + 1], chooseLast = prefixSum[end] - prefixSum[start];
        int a = solve2dDp(stones, start + 1, end);
        int b = solve2dDp(stones, start, end - 1);
        return dp2D[start][end] = Math.max(chooseFirst - a, chooseLast - b);
    }

    public int stoneGameVII2dDp(int[] stones) {
        int n = stones.length;
        dp2D = new int[n + 1][n + 1];
        prefixSum = new int[n + 1];
        for (int i = 1; i <= n; i++)
            prefixSum[i] = prefixSum[i - 1] + stones[i - 1];
        for (int[] i : dp2D)
            Arrays.fill(i, -1);
        return solve2dDp(stones, 0, stones.length - 1);
    }

    public int stoneGameVIIMostEfficientMethodTabular(int[] stones) {
        int n = stones.length;
        int[][] dp = new int[n + 1][n + 1];
        int[] prefixSum = new int[n + 1];
        for (int i = 1; i <= n; i++)
            prefixSum[i] = prefixSum[i - 1] + stones[i - 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= n - 1; j++) {
                if (i > j)
                    continue;
                int chooseFirst = prefixSum[j + 1] - prefixSum[i + 1], chooseLast = prefixSum[j] - prefixSum[i];
                int a = i + 1 > j ? 0 : dp[i + 1][j];
                int b = i > j - 1 ? 0 : dp[i][j - 1];
                dp[i][j] = Math.max(chooseFirst - a, chooseLast - b);
            }
        }
        return dp[0][n - 1];
    }
}

// https://leetcode.com/problems/stone-game-vii/discuss/970268/C++Python-O(n-*-n)/788490