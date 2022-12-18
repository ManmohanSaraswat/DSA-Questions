import java.util.HashMap;
import java.util.Map;

public class SmallestValueAfterReplacingWithSumofPrimeFactors {
    private static Map<Integer, Integer> map;

    private static int find(int n) {
        if (map.containsKey(n))
            return map.get(n);
        int temp = n;
        int sum = 0;
        while (n % 2 == 0) {
            sum += 2;
            n /= 2;
        }
        int x = (int) Math.sqrt(n);
        for (int i = 3; i <= x; i += 2) {
            while (n % i == 0) {
                sum += i;
                n /= i;
            }
        }
        if (n > 2)
            sum += n;
        map.put(temp, sum);
        return find(sum);
    }

    public int smallestValue(int n) {
        map = new HashMap<>();
        return find(n);
    }
}
