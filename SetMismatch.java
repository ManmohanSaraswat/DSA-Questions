public class SetMismatch {
    public int[] findErrorNums(int[] nums) {
        int[] arr = new int[nums.length + 1];
        int[] res = new int[2];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]]++;
            sum += nums[i];
            if (arr[nums[i]] == 2) {
                res[0] = nums[i];
                sum -= nums[i];
            }
        }
        res[1] = ((nums.length * (nums.length + 1)) / 2) - sum;
        return res;
    }
    public int[] findErrorNumsSimplerApproach(int[] nums) {
        int []res = new int[2];
        for(int i: nums){
            if(nums[Math.abs(i) - 1] < 0)
                res[0] = Math.abs(i);
            else
                nums[Math.abs(i) - 1] *= -1;
        }
        for(int i = 0; i < nums.length; i++)
            if(nums[i] > 0) res[1] = i + 1;
        return res;
    }
}