import java.util.Arrays;

public class DeleteOperationforTwoStrings {
    char arr[], brr[];
    int dp[][];

    private int solve(int n, int m) {
        if (n == arr.length || m == brr.length)
            return 0;
        if (dp[n][m] != -1)
            return dp[n][m];
        if (arr[n] == brr[m])
            return dp[n][m] = 1 + solve(n + 1, m + 1);
        return dp[n][m] = Math.max(solve(n + 1, m), solve(n, m + 1));
    }

    public int minDistance(String word1, String word2) {
        arr = word1.toCharArray();
        brr = word2.toCharArray();
        dp = new int[arr.length + 1][brr.length + 1];
        for (int[] i : dp)
            Arrays.fill(i, -1);
        int ans = solve(0, 0);
        System.out.println(ans);
        return arr.length + brr.length - ans * 2;
    }
}
