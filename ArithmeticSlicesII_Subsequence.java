import java.util.HashMap;
import java.util.Map;

public class ArithmeticSlicesII_Subsequence {
    public int numberOfArithmeticSlices(int[] nums) {
        Map<Long, Integer> dp[] = new Map[nums.length];
        dp[0] = new HashMap<>();
        int res = 0;
        for(int i = 1; i < nums.length; i++){
            dp[i] = new HashMap<>();
            for(int j = 0; j < i; j++){
                long diff = (long)nums[i] - nums[j];
                int count = dp[j].getOrDefault(diff, 0);
                res += count;
                dp[i].put(diff, dp[i].getOrDefault(diff, 0) + count + 1);
            }
        }
        return res;
    }
}