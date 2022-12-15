public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] arr = text1.toCharArray();
        char[] brr = text2.toCharArray();
        int[][] dp = new int[arr.length + 1][brr.length + 1];
        for(int i = 1; i <= arr.length; i++){
            for(int j = 1; j <= brr.length; j++){
                if(arr[i - 1] == brr[j - 1]){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[arr.length][brr.length];
    }
}
