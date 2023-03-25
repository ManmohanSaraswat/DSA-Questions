import java.util.*;

public class TheNumberofBeautifulSubsets {
    private boolean contains(List<Integer> list, int target) {
        int n = list.size();
        for (int i = 0; i < n; i++)
            if (list.get(i) == target)
                return true;
        return false;
    }

    private int solve(int[] nums, int n, List<Integer> set, int k) {
        if (n == nums.length) {
            if (set.size() == 0)
                return 0;
            return 1;
        }
        if (contains(set, nums[n] - k) || contains(set, k + nums[n]))
            return solve(nums, n + 1, set, k);
        int res = solve(nums, n + 1, set, k);
        set.add(nums[n]);
        res += solve(nums, n + 1, set, k);
        set.remove(set.size() - 1);
        return res;
    }

    public int beautifulSubsets(int[] nums, int k) {
        return solve(nums, 0, new ArrayList<>(), k);
    }
}
