import java.util.Arrays;

public class MaximumLengthofPairChain {
    public int findLongestChain(int[][] pairs) {
        int dp[] = new int[pairs.length], max = 0;
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));
        Arrays.fill(dp, 1);
        for (int i = 0; i < pairs.length; i++) {
            for (int j = 0; j < i; j++) {
                if (i != j && pairs[i][0] > pairs[j][1]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}