public class StoneGameThree {
    static int[][] dp;
    public static int solve(int[] stoneValue, boolean alice, int cur){
        if(cur == stoneValue.length) return 0;
        if(dp[cur][alice ? 1 : 0] != -1) return dp[cur][alice ? 1 : 0];
        if(alice){
            int ans = 0, res = Integer.MIN_VALUE;
            for(int i = 1; i <= 3 && i + cur - 1< stoneValue.length; i++){
                ans += stoneValue[cur + i - 1];
                res = Math.max(res, ans + solve(stoneValue, !alice, cur + i));
            }
            return dp[cur][alice ? 1 : 0] = res;
        }else{
            int res = Integer.MAX_VALUE;
            for(int i = 1; i <= 3 && i + cur - 1< stoneValue.length; i++){
                res = Math.min(res, solve(stoneValue, !alice, cur + i));
            }
            return dp[cur][alice ? 1 : 0] = res;
        }
    }
    public String stoneGameIII(int[] stoneValue) {
        dp = new int[stoneValue.length + 1][2];
        for(int i = 0; i <= stoneValue.length; i++) dp[i][0] = dp[i][1] = -1;
        int totSum = 0;
        for(Integer i : stoneValue) totSum += i;
        int alice =  solve(stoneValue, true, 0);
        if(totSum - alice < alice)
            return "Alice";
        else if(totSum - alice == alice)
            return "Tie";
        return "Bob";
    }
}