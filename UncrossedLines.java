import java.util.Arrays;

public class UncrossedLines {
    static int[][] dp;

    private int solve(int[] nums1, int[] nums2, int n, int m) {
        if (n == nums1.length || m == nums2.length)
            return 0;
        if (dp[n][m] != -1)
            return dp[n][m];
        if (nums1[n] == nums2[m])
            return dp[n][m] = 1 + solve(nums1, nums2, n + 1, m + 1);
        return dp[n][m] = Math.max(solve(nums1, nums2, n + 1, m), solve(nums1, nums2, n, m + 1));
    }

    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        dp = new int[nums1.length + 1][nums2.length + 1];
        for (int[] i : dp)
            Arrays.fill(i, -1);
        return solve(nums1, nums2, 0, 0);
    }

    public int maxUncrossedLinesTabular2D(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (nums1[i - 1] == nums2[j - 1])
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[n][m];
    }
    public int maxUncrossedLines1D(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int curRow[] = new int[Math.max(n, m) + 1], prevRow[] = new int[Math.max(n, m) + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (nums1[i - 1] == nums2[j - 1])
                    curRow[j] = 1 + prevRow[j - 1];
                else
                    curRow[j] = Math.max(prevRow[j], curRow[j - 1]);
            }
            int[] temp = prevRow;
            prevRow = curRow;
            curRow = temp;
        }
        return prevRow[m];
    }
}
