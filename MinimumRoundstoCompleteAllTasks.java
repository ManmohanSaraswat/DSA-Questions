import java.util.*;

public class MinimumRoundstoCompleteAllTasks {
    Integer[] dp;

    private int solve(int n) {
        if (n == 0)
            return 0;
        if (n < 0)
            return 1000000;
        if (dp[n] != null)
            return dp[n];
        return dp[n] = 1 + Math.min(solve(n - 3), solve(n - 2));
    }

    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap<>();
        dp = new Integer[100010];
        for (int task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int temp = solve(entry.getValue());
            if (temp >= 1000000)
                return -1;
            res += temp;
        }
        return res;
    }
}
