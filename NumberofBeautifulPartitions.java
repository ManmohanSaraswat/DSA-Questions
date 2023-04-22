import java.util.*;

public class NumberofBeautifulPartitions {
    Set<Character> set = new HashSet<>(Arrays.asList('2', '3', '5', '7'));
    int mod = 1000000007;
    Integer dp[][];

    private int solve(char[] arr, int n, int k, int minLength) {
        if (n >= arr.length || k < 0) {
            return k == 0 ? 1 : 0;
        }
        if (k * (minLength == 1 ? 2 : minLength) > arr.length - n)
            return 0;
        if (dp[n][k] != null)
            return dp[n][k];
        int res = 0;
        for (int i = n + minLength - 1; i < arr.length; i++) {
            if (!set.contains(arr[i]))
                if ((i + 1 < arr.length && set.contains(arr[i + 1])) || i + 1 == arr.length)
                    res = (res + solve(arr, i + 1, k - 1, minLength) % mod) % mod;
        }
        return dp[n][k] = res;
    }

    public int beautifulPartitions(String s, int k, int minLength) {
        char[] arr = s.toCharArray();
        if (!set.contains(arr[0]) || set.contains(arr[arr.length - 1]))
            return 0;
        dp = new Integer[arr.length][k + 1];
        return solve(arr, 0, k, minLength);
    }
}
