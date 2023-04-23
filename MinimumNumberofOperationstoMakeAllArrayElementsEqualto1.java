public class MinimumNumberofOperationstoMakeAllArrayElementsEqualto1 {
    private int gcd(int a, int b) {
        if (b != 0)
            return gcd(b, a % b);
        return a;
    }

    public int minOperations(int[] nums) {
        int res = Integer.MAX_VALUE, cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1)
                cnt++;
        }
        if (cnt != 0)
            return nums.length - cnt;
        for (int i = 0; i < nums.length; i++) {
            int g = nums[i];
            for (int j = i; j < nums.length; j++) {
                g = gcd(g, nums[j]);
                if (g == 1) {
                    res = Math.min(res, j - i);
                    break;
                }
            }
        }
        if (res == Integer.MAX_VALUE)
            return -1;
        return res + nums.length - 1;
    }
}
