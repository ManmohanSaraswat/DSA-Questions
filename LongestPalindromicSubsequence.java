public class LongestPalindromicSubsequence {
    Integer dp[][];

    private int solve(char[] arr, int start, int end) {
        if (dp[start][end] != null)
            return dp[start][end];
        if (start == end)
            return 1;
        else if (start > end)
            return 0;
        else {
            if (arr[start] == arr[end]) {
                return dp[start][end] = 2 + solve(arr, start + 1, end - 1);
            } else {
                return dp[start][end] = Math.max(solve(arr, start + 1, end), solve(arr, start, end - 1));
            }
        }
    }

    public int longestPalindromeSubseq(String s) {
        char[] arr = s.toCharArray();
        dp = new Integer[arr.length][arr.length];
        return solve(arr, 0, arr.length - 1);
    }
}
