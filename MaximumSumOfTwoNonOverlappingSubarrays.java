public class MaximumSumOfTwoNonOverlappingSubarrays {
    private int helper(int[] nums, int start, int end, int len){
        if(start > end || (end - start + 1) < len) return -1;
        int currentWindow = 0, maxSum = 0;
        for(int i = start, j = 0; i <= end; i++){
            if(i - start + 1 <= len){
                currentWindow += nums[i];
            }else{
                currentWindow = currentWindow + nums[i] - nums[start + j];
                j ++;
            }
            maxSum = Math.max(maxSum, currentWindow);
        }
        return maxSum; 
    }
    private int maxSumTwo(int[] nums, int firstLen, int secondLen) {
        int maxAns = 0;
        for(int i = 0; i + secondLen < nums.length; i++){
            int lenA = helper(nums, 0, i - 1, firstLen);
            int lenB = helper(nums, i + secondLen, nums.length - 1, firstLen);
            int ans = 0;
            for(int j = i; j < i + secondLen; j++)
                ans += nums[j];
            
            maxAns = Math.max(maxAns, ans + Math.max(lenA, lenB));
        }
        return maxAns;
    }
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen){
        return Math.max(maxSumTwo(nums, firstLen, secondLen), maxSumTwo(nums, secondLen, firstLen));
    }
}