public class InterleavingString {
    Boolean[][] dp;

    private boolean solve(char[] arr, char[] brr, char[] crr, int a, int b, int c) {
        if (a == arr.length && b == brr.length && c == crr.length)
            return true;
        if (dp[a][b] != null)
            return dp[a][b];
        if (a < arr.length && b < brr.length && c < crr.length && arr[a] == brr[b] && arr[a] == crr[c])
            return dp[a][b] = solve(arr, brr, crr, a + 1, b, c + 1) || solve(arr, brr, crr, a, b + 1, c + 1);
        else if (a < arr.length && c < crr.length && arr[a] == crr[c])
            return dp[a][b] = solve(arr, brr, crr, a + 1, b, c + 1);
        else if (b < brr.length && c < crr.length && brr[b] == crr[c])
            return dp[a][b] = solve(arr, brr, crr, a, b + 1, c + 1);
        return dp[a][b] = false;
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        char[] arr = s1.toCharArray();
        char[] brr = s2.toCharArray();
        char[] crr = s3.toCharArray();
        dp = new Boolean[arr.length + 1][brr.length + 1];
        return solve(arr, brr, crr, 0, 0, 0);
    }
}
