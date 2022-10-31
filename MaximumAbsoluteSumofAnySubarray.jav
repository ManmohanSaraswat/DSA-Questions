public class MaximumAbsoluteSumofAnySubarray{
    public int maxAbsoluteSum(int[] nums) {
        int sum = 0, maxSum = 0, minSum = 0;
        for(int i : nums){
            if(sum < 0)
                sum = i;
            else
                sum += i; 
            maxSum = Math.max(sum, maxSum);
        }
        sum = 0;
        for(int i : nums){
            if(sum >= 0)
                sum = i;
            else
                sum += i;   
            minSum = Math.min(sum, minSum);
        }
        return Math.max(Math.abs(minSum), maxSum);
    }
}