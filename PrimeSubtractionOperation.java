import java.util.*;

public class PrimeSubtractionOperation {
    List<Integer> primes;

    private void calcPrimes() {
        for (int n = 2; n < 1000; n++) {
            int m = (int) Math.sqrt(n);
            boolean flag = true;
            for (int i = 2; i <= m; i++) {
                if (n % i == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                primes.add(n);
        }
    }

    public boolean primeSubOperation(int[] nums) {
        primes = new ArrayList<>();
        calcPrimes();
        int temp = -1, prev = nums[0];
        for (int i : primes) {
            if (nums[0] > i) {
                temp = nums[0] - i;
            } else {
                break;
            }
        }
        if (temp != -1)
            prev = temp;
        else
            prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            temp = nums[i];
            for (int j : primes) {
                if (nums[i] > j) {
                    if (prev < nums[i] - j) {
                        temp = nums[i] - j;
                    }
                } else {
                    break;
                }
            }
            if (prev >= temp) {
                return false;
            }
            prev = temp;
        }
        return true;
    }
}
