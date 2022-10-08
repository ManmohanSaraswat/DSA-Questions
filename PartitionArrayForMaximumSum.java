public class PartitionArrayForMaximumSum {
    static int dp[];
    private int find(int []arr, int k, int index){
        if(index >= arr.length) return 0;
        if(dp[index] != -1) return dp[index];
        int maxValue = 0, currentSum = 0, finalAnswer = 0;
        for(int i = 1; i <= k && index + i - 1 < arr.length; i++){
            maxValue = Math.max(maxValue, arr[index + i - 1]);
            currentSum = maxValue * (i);
            finalAnswer = Math.max(finalAnswer, currentSum + find(arr, k, index + i));
        }
        return dp[index] = finalAnswer;
    }
    public int maxSumAfterPartitioningMemoization(int[] arr, int k) {
        dp = new int[arr.length];
        for(int i = 0; i < arr.length; i++) dp[i] = -1;
        return find(arr, k, 0);
    }

    public int maxSumAfterPartitioningTabular(int[] arr, int k){
        int []tabular = new int[arr.length+1];
        for(int i = 0; i < arr.length+1; i++){
            int maxValue = 0, currentSum = 0;
            for(int j = 1; j <= k && i - j >= 0; j++){
                maxValue = Math.max(maxValue, arr[i - j]);
                currentSum = maxValue * j;
                tabular[i] = Math.max(tabular[i], currentSum + tabular[i - j]);
            }
        }
        return tabular[arr.length];
    }
}
