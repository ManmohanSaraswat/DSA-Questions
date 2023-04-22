public class PrimeInDiagonal {
    private int isPrime(int n) {
        if (n == 1)
            return -10;
        int m = (int) Math.sqrt(n);
        for (int i = 2; i <= m; i++) {
            if (n % i == 0)
                return -10;
        }
        return n;
    }

    public int diagonalPrime(int[][] nums) {
        int maxPrime = 0;
        for (int i = 0; i < nums.length; i++) {
            maxPrime = Math.max(maxPrime, isPrime(nums[i][i]));
            maxPrime = Math.max(maxPrime, isPrime(nums[i][nums.length - i - 1]));
        }
        return maxPrime;
    }
}
