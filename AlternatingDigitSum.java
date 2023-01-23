import java.util.*;

public class AlternatingDigitSum {
    public int alternateDigitSum(int n) {
        List<Integer> lst = new ArrayList<>();
        while (n > 0) {
            lst.add(n % 10);
            n /= 10;
        }
        n = lst.size();
        int sum = 0;
        boolean sign = true;
        for (int i = n - 1; i >= 0; i--) {
            if (sign) {
                sum += lst.get(i);
                sign = false;
            } else {
                sum -= lst.get(i);
                sign = true;
            }
        }
        return sum;
    }
}
