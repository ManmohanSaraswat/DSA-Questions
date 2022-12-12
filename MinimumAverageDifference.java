public class MinimumAverageDifference {
    public int minimumAverageDifference(int[] nums) {
        long prefixSum[] = new long[nums.length + 1];
        for(int i = 0; i < nums.length; i++){
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        int minDiff = Integer.MAX_VALUE;
        int minIndex = 0;
        for(int i = 0; i < nums.length; i++){
            int firsts = (int) (prefixSum[i + 1] / (i + 1));
            int lasts = (int) ((i + 1) == nums.length ? 0 : (prefixSum[nums.length] - prefixSum[i + 1]) / (nums.length - i - 1));
            int temp = Math.abs(firsts - lasts);
            if(temp < minDiff){
                minDiff = temp;
                minIndex = i;
            }
        }
        return minIndex;
    }
}
