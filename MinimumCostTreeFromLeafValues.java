public class MinimumCostTreeFromLeafValues {
    static int dp[][];
    public static int max(int []arr, int start, int end){
        int max = arr[start];
        for(int i = start + 1; i <= end; i++)
            max = Math.max(max, arr[i]);
        return max;
    }
    public static int find(int[] arr, int start, int end){
        if(start == end) return 0;
        if(start + 1 == end) return arr[start] * arr[end];
        if(dp[start][end] != -1) return dp[start][end];
        int minProd = Integer.MAX_VALUE;
        for(int i = start; i < end; i++){
            int left = find(arr, start, i);
            int right = find(arr, i+1, end);
            int sum = max(arr, start, i) * max(arr, i + 1, end) + left + right;
            minProd = Math.min(minProd, sum);
        }
        return dp[start][end] = minProd;
    }
    public static int mctFromLeafValues(int[] arr) {
        int n = arr.length;
        dp = new int[n+1][n+1];
        for(int i = 0; i <= n; i++) for(int j = 0; j <= n; j++) dp[i][j] = -1;
        return find(arr, 0, arr.length-1);
    }
    public static void main(String[] args) {
        int []arr = new int[]{6, 2, 4};
        System.out.println(mctFromLeafValues(arr));
    }
}
