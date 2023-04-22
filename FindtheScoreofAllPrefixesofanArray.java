public class FindtheScoreofAllPrefixesofanArray {
    public long[] findPrefixScore(int[] nums) {
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = Math.max(nums[i], prefix[i - 1]);
        }
        long[] res = new long[prefix.length];
        res[0] = nums[0] * 1L + prefix[0] * 1L;
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i - 1] + nums[i] * 1L + prefix[i] * 1L;
        }
        return res;
    }
}