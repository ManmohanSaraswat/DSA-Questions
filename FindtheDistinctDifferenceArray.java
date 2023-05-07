import java.util.*;

public class FindtheDistinctDifferenceArray {
    public int[] distinctDifferenceArray(int[] nums) {
        int[] prefix = new int[nums.length + 1];
        int[] suffix = new int[nums.length + 2];
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= nums.length; i++) {
            set.add(nums[i - 1]);
            prefix[i] = set.size();
        }
        set = new HashSet<>();
        for (int i = nums.length; i >= 1; i--) {
            set.add(nums[i - 1]);
            suffix[i] = set.size();
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = prefix[i + 1] - suffix[i + 2];
        }
        return res;
    }
}
