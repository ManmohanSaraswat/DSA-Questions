public class CountNumberswithUniqueDigits {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0)
            return 1;
        int x = 9, sum = 9;
        for (int i = 2; i <= n; i++) {
            sum *= x--;
        }
        return sum + countNumbersWithUniqueDigits(n - 1);
    }

    private static int solve(int cur, int bit, int max) {
        if (cur >= max)
            return 0;
        int ans = 1;
        for (int i = 0; i < 10; i++) {
            if (cur == 0 && i == 0)
                continue;
            if ((bit & (1 << i)) == 0) {
                ans += solve(cur * 10 + i, bit | (1 << i), max);
            }
        }
        return ans;
    }

    public int countNumbersWithUniqueDigitsEfficient(int n) {
        return solve(0, 0, (int) Math.pow(10, n));
    }
}
