import java.util.*;

public class CountNumberofBadPairs {
    public long countBadPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(i - nums[i], map.getOrDefault(i - nums[i], 0) + 1);
        }
        long res = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int val = entry.getValue();
            res += (val * 1L * (val - 1)) / 2;
        }
        return (nums.length * 1L * (nums.length - 1)) / 2 - res;
    }
}
