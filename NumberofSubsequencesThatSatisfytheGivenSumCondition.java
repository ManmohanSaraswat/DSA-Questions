import java.util.Arrays;

public class NumberofSubsequencesThatSatisfytheGivenSumCondition {
    int mod = 1000000007;

    public int numSubseq(int[] nums, int target) {
        int n = nums.length, i = 0, j = n - 1, res = 0;
        Arrays.sort(nums);
        int[] pow = new int[n + 1];
        pow[0] = 1;
        for (int k = 1; k <= n; k++)
            pow[k] = (pow[k - 1] * 2) % mod;
        while (i <= j) {
            while (i <= j && nums[i] + nums[j] > target)
                j--;
            if (i <= j && nums[i] + nums[j] <= target) {
                res = (res + pow[j - i]) % mod;
            } else {
                break;
            }
            i++;
        }
        return res;
    }
}
