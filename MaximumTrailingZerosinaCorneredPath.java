public class MaximumTrailingZerosinaCorneredPath {
    private int solve(int[][][] hr, int[][][] vr, int i, int j, int[][][] pr) {
        int left[] = new int[] { hr[i][j][0], hr[i][j][1] };
        int top[] = new int[] { vr[i][j][0], vr[i][j][1] };
        int right[], down[];
        if (j - 1 >= 0) {
            right = new int[] { hr[i][hr[0].length - 1][0] - hr[i][j - 1][0],
                    hr[i][hr[0].length - 1][1] - hr[i][j - 1][1] };

        } else {
            right = new int[] { hr[i][hr[0].length - 1][0], hr[i][hr[0].length - 1][1] };

        }
        if (i - 1 >= 0)
            down = new int[] { vr[vr.length - 1][j][0] - vr[i - 1][j][0], vr[vr.length - 1][j][1] - vr[i - 1][j][1] };
        else
            down = new int[] { vr[vr.length - 1][j][0], vr[vr.length - 1][j][1] };
        int a = Math.max(Math.min(left[0] + top[0] - pr[i][j][0], left[1] + top[1] - pr[i][j][1]),
                Math.min(left[0] + down[0] - pr[i][j][0], left[1] + down[1] - pr[i][j][1]));
        int b = Math.max(Math.min(right[0] + top[0] - pr[i][j][0], right[1] + top[1] - pr[i][j][1]),
                Math.min(right[0] + down[0] - pr[i][j][0], right[1] + down[1] - pr[i][j][1]));
        return Math.max(a, b);
    }

    public int maxTrailingZeros(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][][] prefix = new int[n][m][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int temp = grid[i][j], c2 = 0, c5 = 0;
                while (temp % 5 == 0) {
                    c5++;
                    temp /= 5;
                }
                while (temp % 2 == 0) {
                    c2++;
                    temp /= 2;
                }
                prefix[i][j][0] = c2;
                prefix[i][j][1] = c5;
            }
        }
        int[][][] hrPrefix = new int[n][m][2];
        int[][][] vrPrefix = new int[n][m][2];
        for (int i = 0; i < n; i++) {
            hrPrefix[i][0][0] = prefix[i][0][0];
            hrPrefix[i][0][1] = prefix[i][0][1];
            for (int j = 1; j < m; j++) {
                hrPrefix[i][j][0] = hrPrefix[i][j - 1][0] + prefix[i][j][0];
                hrPrefix[i][j][1] = hrPrefix[i][j - 1][1] + prefix[i][j][1];
            }
        }
        for (int j = 0; j < m; j++) {
            vrPrefix[0][j][0] = prefix[0][j][0];
            vrPrefix[0][j][1] = prefix[0][j][1];
            for (int i = 1; i < n; i++) {
                vrPrefix[i][j][0] = vrPrefix[i - 1][j][0] + prefix[i][j][0];
                vrPrefix[i][j][1] = vrPrefix[i - 1][j][1] + prefix[i][j][1];
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res = Math.max(res, solve(hrPrefix, vrPrefix, i, j, prefix));
            }
        }
        return res;
    }
}
