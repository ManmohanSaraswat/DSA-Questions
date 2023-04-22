import java.util.*;

public class MakeArrayZerobySubtractingEqualAmounts {
    public int minimumOperations(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++)
            set.add(nums[i]);
        int res = set.size();
        if (set.contains(0))
            res--;
        return res;
    }
}
