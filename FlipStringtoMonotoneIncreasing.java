import java.util.Arrays;

public class FlipStringtoMonotoneIncreasing {
    int[][] dp;
    char[] arr;

    public int solve(int n, int last) {
        if (n == arr.length)
            return 0;
        if (dp[n][last] != -1)
            return dp[n][last];
        int deletedChars = 1000000;
        if (last == 0) {
            if (arr[n] == '0')
                deletedChars = 1 + solve(n + 1, 1);
            else
                deletedChars = 1 + solve(n + 1, 0);
            deletedChars = Math.min(deletedChars, solve(n + 1, arr[n] - '0'));
        } else {
            if (arr[n] == '0')
                deletedChars = 1 + solve(n + 1, 1);
            else
                deletedChars = solve(n + 1, 1);
        }
        return dp[n][last] = deletedChars;
    }

    public int minFlipsMonoIncr(String s) {
        arr = s.toCharArray();
        dp = new int[s.length() + 1][2];
        for (int[] i : dp)
            Arrays.fill(i, -1);
        return Math.min(solve(0, 1), solve(0, 0));
    }
}