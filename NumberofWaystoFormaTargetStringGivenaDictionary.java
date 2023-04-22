public class NumberofWaystoFormaTargetStringGivenaDictionary {
    Long dp[][];
    int mod = 1000000007;

    private long solve(int[][] prefix, char[] target, int n, int m, int N) {
        if (m == target.length)
            return 1;
        if (n == N)
            return 0;
        if (dp[n][m] != null)
            return dp[n][m];
        long res = solve(prefix, target, n + 1, m, N), temp = 0;
        if (prefix[n][target[m] - 'a'] > 0) {
            temp = ((solve(prefix, target, n + 1, m + 1, N) % mod) * (prefix[n][target[m] - 'a'] % mod)) % mod;
        }
        res = ((res % mod) + (temp % mod)) % mod;
        return dp[n][m] = res;
    }

    public int numWays(String[] words, String target) {
        char[] arr = target.toCharArray();
        int[][] prefix = new int[words[0].length()][26];
        for (int i = 0; i < prefix.length; i++) {
            for (int j = 0; j < words.length; j++) {
                prefix[i][words[j].charAt(i) - 'a']++;
            }
        }
        dp = new Long[words[0].length()][arr.length];
        return (int) solve(prefix, arr, 0, 0, dp.length);
    }
}
