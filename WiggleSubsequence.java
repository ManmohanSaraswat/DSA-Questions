import java.util.ArrayList;
import java.util.List;

public class WiggleSubsequence {
    private int solve(int[] nums, int n, List<Integer> lst) {
        if (n == nums.length) {
            if (lst.size() <= 2)
                return lst.size();
            int first = lst.get(1), s = lst.size();
            boolean pos = first > lst.get(0);
            for (int i = 2; i < s; i++) {
                if (pos && lst.get(i) - first < 0) {
                    pos = false;
                    first = lst.get(i);
                } else if (!pos && lst.get(i) - first > 0) {
                    pos = true;
                    first = lst.get(i);
                } else
                    return 0;
            }
            return lst.size();
        }
        List<Integer> nlst = new ArrayList<>(lst);
        nlst.add(nums[n]);
        return Math.max(solve(nums, n + 1, lst), solve(nums, n + 1, nlst));
    }

    public int wiggleMaxLength(int[] nums) {
        return solve(nums, 0, new ArrayList<>());
    }

    public int wiggleMaxLength2dDP(int[] nums) {
        int[][] dp = new int[nums.length][2];
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    dp[i][0] = Math.max(dp[i][0], 1 + dp[j][1]);
                else if (nums[i] < nums[j])
                    dp[i][1] = Math.max(dp[i][1], 1 + dp[j][0]);
            }
            res = Math.max(res, Math.max(dp[i][0], dp[i][1]));
        }
        return 1 + res;
    }
    public int wiggleMaxLength1dDP(int[] nums) {
        int inc = 1, desc = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums[i - 1])
                inc = desc + 1;
            else if(nums[i] < nums[i - 1])
                desc = inc + 1;
        }
        return Math.max(inc, desc);
    }
}
