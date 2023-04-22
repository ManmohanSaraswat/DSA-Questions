import java.util.Arrays;

public class FindtheMaximumDivisibilityScore {
    public int maxDivScore(int[] nums, int[] divisors) {
        int minDiv = Integer.MAX_VALUE, temp = 0, res[][] = new int[divisors.length][2];
        for (int i = 0; i < res.length; i++) {
            int div = divisors[i];
            temp = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] % div == 0)
                    temp++;
            }
            res[i][0] = temp;
            res[i][1] = div;
        }
        Arrays.sort(res, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        return res[0][1];
    }
}
