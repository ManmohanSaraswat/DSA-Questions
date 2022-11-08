import java.util.Arrays;

public class CountNumberofTexts {
    char[] arr;
    int brr[], dp[], mod = 1_000_000_007;

    private int solve(int n) {
        if (n >= arr.length)
            return 1;
        if (dp[n] != -1)
            return dp[n];
        int freq = brr[arr[n] - '0'], count = 0;
        for (int i = 0; i + n < arr.length && i < freq && arr[n] == arr[i + n]; i++) {
            count = (count % mod + solve(i + n + 1) % mod) % mod;
        }
        return dp[n] = count;
    }

    public int countTexts(String pressedKeys) {
        arr = pressedKeys.toCharArray();
        dp = new int[arr.length + 1];
        Arrays.fill(dp, -1);
        brr = new int[] { 0, 0, 3, 3, 3, 3, 3, 4, 3, 4 };
        return solve(0);
    }

    public int countTextsTabular(String pressedKeys) {
        arr = pressedKeys.toCharArray();
        dp = new int[arr.length + 1];
        brr = new int[] { 0, 0, 3, 3, 3, 3, 3, 4, 3, 4 };
        dp[0] = 1;
        for (int i = 1; i <= arr.length; i++) {
            int freq = brr[arr[i - 1] - '0'], count = 0;
            for (int j = 0; i - j - 1 >= 0 && j < freq && arr[i - 1] == arr[i - j - 1]; j++) {
                count = (count % mod + dp[i - j - 1] % mod) % mod;
            }
            dp[i] = count;
        }
        return dp[arr.length];
    }
}
