public class SuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] primePointers = new int[primes.length];
        long[] dp = new long[n];
        dp[0] = 1L;
        for (int i = 1; i < n; i++) {
            int index = 0;
            dp[i] = Long.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                if (primes[j] * dp[primePointers[j]] < dp[i]) {
                    dp[i] = primes[j] * dp[primePointers[j]];
                    index = j;
                }
            }
            if (dp[i - 1] == dp[i])
                i--;
            primePointers[index]++;
        }
        return (int) dp[n - 1];
    }
}
