import java.util.Arrays;

public class BeautifulArrangement {
    static int n;
    static int dp[][];
    public static int solve(int i, int bit){
        if(i == n + 1) return 1;
        if(dp[i][bit] != -1) return dp[i][bit];
        int ans = 0;
        for(int j = 1; j <= n; j++){
            if((bit & (1 << (j-1))) == 0){
                if(j % i == 0 || i % j == 0){
                    ans += solve(i + 1, bit + (1 << (j-1)));
                }
            }
        }
        return dp[i][bit] = ans;
    }
    public int countArrangement(int x) {
        dp = new int[16][1 << x];
        for(int i = 0; i < 16; i++) Arrays.fill(dp[i], -1);
        n = x;
        return solve(1, 0);
    }
}
