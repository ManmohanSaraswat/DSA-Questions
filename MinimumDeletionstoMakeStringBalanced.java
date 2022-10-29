import java.util.Arrays;

public class MinimumDeletionstoMakeStringBalanced {
    char[] arr;
    int[][] dp;

    private int solve(int n, int last) {
        if (n == arr.length)
            return 0;
        if (dp[n][last] != -1)
            return dp[n][last];
        if (last == 0) {
            int a, b;
            if (arr[n] == 'a') {
                a = 1 + solve(n + 1, 1);
                b = solve(n + 1, 0);
            } else {
                a = 1 + solve(n + 1, 0);
                b = solve(n + 1, 1);
            }
            return dp[n][last] = Math.min(a, b);
        } else {
            if (arr[n] == 'a')
                return dp[n][last] = 1 + solve(n + 1, 1);
            return dp[n][last] = solve(n + 1, 1);
        }
    }

    public int minimumDeletions(String s) {
        arr = s.toCharArray();
        dp = new int[arr.length + 1][2];
        for (int[] i : dp)
            Arrays.fill(i, -1);
        return Math.min(solve(0, 0), solve(0, 1));
    }

    public int minimumDeletionsTopDown(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int[][] dp = new int[n + 1][2];
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] == 'a') {
                dp[i][0] = Math.min(1 + dp[i + 1][1], dp[i + 1][0]);
            } else {
                dp[i][0] = Math.min(1 + dp[i + 1][0], dp[i + 1][1]);
            }

            if (arr[i] == 'a')
                dp[i][1] = 1 + dp[i + 1][1];
            else
                dp[i][1] = dp[i + 1][1];

        }
        return Math.min(dp[0][0], dp[0][1]);
    }

    public int minimumDeletionsTopDownO1Space(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int prevA = 0, prevB = 0, curA = 0, curB = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] == 'a') {
                curA = Math.min(1 + prevB, prevA);
                curB = 1 + prevB;
            } else {
                curA = Math.min(1 + prevA, prevB);
                curB = prevB;
            }
            prevA = curA;
            prevB = curB;

        }
        return Math.min(curA, curB);
    }
    public int minimumDeletionsEfficientApproach(String s) {
        char[] arr = s.toCharArray();
        int ans = 0, b = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 'b') b++;
            else ans = Math.min(ans + 1, b);
        }
        return ans;
    }
}
