public class LeftandRightSumDifferences {
    public int[] leftRigthDifference(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        int[] res = new int[nums.length];
        prefix[0] = nums[0];
        suffix[nums.length - 1] = nums[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + nums[i];
        }
        if (nums.length > 1) {
            res[0] = suffix[1];
            res[nums.length - 1] = prefix[nums.length - 2];
        }
        for (int i = 1; i < nums.length - 1; i++) {
            res[i] = Math.abs(prefix[i] - suffix[i]);
        }
        return res;
    }
}
