import java.util.Arrays;

public class MinimumCostForATicket {
    static int dp[];
    public static int solve(int[] days, int[] costs, int curDay){
        if(curDay == days.length) return 0;
        if(dp[curDay] != -1) return dp[curDay];
        int a = costs[0] + solve(days, costs, curDay + 1);
        int i = 0;
        while(curDay + i < days.length && days[curDay + i] <= days[curDay] + 6)
            i ++;
        int b = costs[1] + solve(days, costs, curDay + i);
        i = 0;
        while(curDay + i < days.length && days[curDay + i] <= days[curDay] + 29)
            i++;
        int c = costs[2] + solve(days, costs, curDay + i);
        return dp[curDay] = Math.min(a, Math.min(b, c));
    }
    public int mincostTickets(int[] days, int[] costs) {
        dp = new int[366];
        Arrays.fill(dp, -1);
        return solve(days, costs, 0);
    }
}
