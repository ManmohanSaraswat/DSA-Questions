public class MaximumSumCircularSubarray {
    private int kadaneAlgo(int[] nums) {
        int max = nums[0], cur = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (cur < 0)
                cur = nums[i];
            else
                cur += nums[i];
            max = Math.max(cur, max);
        }
        return max;
    }

    public int maxSubarraySumCircular(int[] nums) {
        int subarrSum = kadaneAlgo(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            nums[i] *= -1;
        }
        int negsubArrSum = kadaneAlgo(nums);
        int circularSubArrSum = sum + negsubArrSum;
        if (circularSubArrSum == 0)
            return subarrSum;
        return Math.max(circularSubArrSum, subarrSum);
    }
}