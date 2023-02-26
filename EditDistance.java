import java.util.*;

public class EditDistance {
    int[][] dp;

    private int find(char[] arr, char[] brr, int n, int m) {
        if (n == arr.length || m == brr.length) {
            if (m == brr.length)
                return arr.length - n;
            return brr.length - m;
        }
        if (dp[n][m] != -1)
            return dp[n][m];
        if (arr[n] == brr[m])
            return dp[n][m] = find(arr, brr, n + 1, m + 1);
        return dp[n][m] = 1
                + Math.min(find(arr, brr, n + 1, m), Math.min(find(arr, brr, n, m + 1), find(arr, brr, n + 1, m + 1)));
    }

    public int minDistance(String word1, String word2) {
        char[] arr = word1.toCharArray();
        char[] brr = word2.toCharArray();
        dp = new int[arr.length][brr.length];
        for (int i[] : dp)
            Arrays.fill(i, -1);
        return find(arr, brr, 0, 0);
    }
}
