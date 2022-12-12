import java.util.Arrays;

public class LargestSumofAverages {
    static double dp[][];
    private double solve(int[] nums, int k, int n){
        if(n >= nums.length) return 0;
        if(k == 1){
            double sum = 0;
            for(int i = n; i < nums.length; i++) sum += nums[i];
            return sum / (nums.length - n);
        }
        if(dp[n][k] != -1) return dp[n][k];
        double max = 0, sum = 0;
        for(int i = n; i < nums.length; i++){
            sum += nums[i];
            double avg = sum / (i - n + 1);
            max = Math.max(max, avg + solve(nums, k - 1, i + 1));
        }
        return dp[n][k] = max;
    }
    public double largestSumOfAverages(int[] nums, int k) {
        dp = new double[nums.length + 1][k + 1];
        for(double[] i: dp)
            Arrays.fill(i, -1);
        return solve(nums, k, 0);
    }
}
