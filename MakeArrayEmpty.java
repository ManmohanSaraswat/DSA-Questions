import java.util.*;

public class MakeArrayEmpty {
    public long countOperationsToEmptyArray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        Arrays.sort(nums);
        long res = nums.length;
        for (int i = 1; i < nums.length; i++) {
            if (map.get(nums[i]) < map.get(nums[i - 1]))
                res += nums.length - i;
        }
        return res;
    }
}