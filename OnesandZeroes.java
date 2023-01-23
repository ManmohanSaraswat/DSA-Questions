import java.util.*;

public class OnesandZeroes {
    int dp[][][];

    private int solve(int[][] arr, int index, int n, int m) {
        if (index == arr.length)
            return 0;
        if (dp[index][n][m] != -1)
            return dp[index][n][m];
        if (n >= arr[index][0] && m >= arr[index][1]) {
            return dp[index][n][m] = Math.max(1 + solve(arr, index + 1, n - arr[index][0], m - arr[index][1]),
                    solve(arr, index + 1, n, m));
        } else
            return dp[index][n][m] = solve(arr, index + 1, n, m);
    }

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] arr = new int[strs.length][2];
        dp = new int[strs.length][m + 1][n + 1];
        for (int i[][] : dp)
            for (int j[] : i)
                Arrays.fill(j, -1);
        for (int i = 0; i < strs.length; i++) {
            char[] brr = strs[i].toCharArray();
            for (int j = 0; j < brr.length; j++)
                if (brr[j] == '0')
                    arr[i][0]++;
                else
                    arr[i][1]++;
        }
        return solve(arr, 0, m, n);
    }
}
