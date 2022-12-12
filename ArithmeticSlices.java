public class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length, count = 0;
        for(int i = 0; i < n-2; i++){
            int diff = nums[i+1] - nums[i];
            for(int j = i+2; j < n; j++){
                if(diff == nums[j] - nums[j-1]) count ++;
                else break;
            }
        }
        return count;
    }
}