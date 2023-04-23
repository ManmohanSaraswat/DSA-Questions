public class RestoreTheArray {
    Integer[] dp;
    int mod = 1000000007;

    private int solve(char[] arr, long k, int n) {
        if (n == arr.length)
            return 1;
        long temp = 0;
        int res = 0;
        if (arr[n] == '0')
            return 0;
        if (dp[n] != null)
            return dp[n];
        for (int i = n; i < arr.length; i++) {
            temp = temp * 10 + (arr[i] - '0');
            if (temp != 0 && temp <= k)
                res = (res + solve(arr, k, i + 1) % mod) % mod;
            if (temp > k)
                return dp[n] = res;
        }
        return dp[n] = res;
    }

    public int numberOfArrays(String s, int k) {
        char[] arr = s.toCharArray();
        dp = new Integer[arr.length];
        return solve(arr, k, 0);
    }
}