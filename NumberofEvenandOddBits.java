public class NumberofEvenandOddBits {
    public int[] evenOddBit(int n) {
        int even = 0, odd = 0, count = 0;
        while (n > 0) {
            if (n % 2 != 0) {
                if (count % 2 == 0)
                    even++;
                else
                    odd++;
            }
            count++;
            n /= 2;
        }
        return new int[] { even, odd };
    }
}
