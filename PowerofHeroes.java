import java.util.Arrays;

public class PowerofHeroes {
    int mod = 1000000007;

    private long modAdd(long a, long b) {
        return (a % mod + b % mod) % mod;
    }

    private long modMul(long a, long b) {
        return ((a % mod) * (b % mod)) % mod;
    }

    public int sumOfPower(int[] nums) {
        Arrays.sort(nums);
        long sum = 0, res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = modAdd(res, modMul(modMul(nums[i], nums[i]), modAdd(sum, nums[i])));
            sum = modAdd(sum * 2, nums[i]);
        }
        return (int) res;
    }
}
