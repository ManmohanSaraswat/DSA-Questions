public class ArithmeticSlices {
    public int find(int[] arr, int n, int diff){
        if(n + 2 == arr.length){
            if(Math.abs(arr[n] - arr[n+1]) == Math.abs(arr[n+1] - arr[n+2])) return 1;
            return 0;
        }
        int diff1 = Math.abs(arr[n] - arr[n+1]);
        int diff2 = Math.abs(arr[n+1] - arr[n+2]);
        if(diff1 == diff2){
            return 1 + find(arr, n+1, diff1) + find(arr, n+2, -1);
        }else{
            return find(arr, n+1, -1);
        }
    }
    public static int numberOfArithmeticSlices(int[] nums) {
        int dp[] = new int[nums.length-1];
        for(int i = 0; i < nums.length-1; i++)
            dp[i] = Math.abs(nums[i] - nums[i+1]);
        int count = 0, curDiff = dp[0];
        for(int i = 1; i < dp.length; i++){
            if(dp[i] == dp[i-1])count ++;
            else curDiff = dp[i];
        }
        return count;
    }
}