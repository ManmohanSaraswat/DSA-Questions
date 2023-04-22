public class MinimumNumberofFoodBucketstoFeedtheHamsters {
    Integer[] dp;

    private int solve(char[] arr, int n) {
        if (n >= arr.length)
            return 0;
        if (dp[n] != null)
            return dp[n];
        if (arr[n] == '.')
            return dp[n] = solve(arr, n + 1);
        if (n == 0 && arr.length > 1 && arr[n + 1] == 'H')
            return dp[n] = 1000000;
        if (n == arr.length - 1 && arr.length > 1 && arr[n - 1] == 'H')
            return dp[n] = 1000000;
        if (n > 0 && n < arr.length - 1 && arr.length >= 3 && arr[n - 1] == 'H' && arr[n + 1] == 'H')
            return dp[n] = 1000000;
        if (n > 0 && n < arr.length - 1 && arr.length >= 3 && arr[n - 1] == '.' && arr[n + 1] == '.')
            return dp[n] = 1 + Math.min(solve(arr, n + 2), solve(arr, n + 3));
        if (n > 0 && arr[n - 1] == '.')
            return dp[n] = 1 + solve(arr, n + 1);
        if (n < arr.length - 1 && arr[n + 1] == '.')
            return dp[n] = 1 + solve(arr, n + 3);
        return dp[n] = 1000000;
    }

    public int minimumBuckets(String hamsters) {
        char[] arr = hamsters.toCharArray();
        dp = new Integer[arr.length];
        int res = solve(arr, 0);
        return res >= 1000000 ? -1 : res;
    }
}
