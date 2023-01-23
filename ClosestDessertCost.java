import java.util.*;

public class ClosestDessertCost {
    int[][] dp;

    private int solve(int[] toppings, int n, int target) {
        if (n == toppings.length || target < 0)
            return 0;
        if (target >= 0 && dp[n][target] != -1)
            return dp[n][target];
        int a1 = solve(toppings, n + 1, target);
        int a2 = toppings[n] + solve(toppings, n + 1, target - toppings[n]);
        int a3 = 2 * toppings[n] + solve(toppings, n + 1, target - 2 * toppings[n]);
        int x1 = Math.abs(target - a1), x2 = Math.abs(target - a2), x3 = Math.abs(target - a3);
        int minDiff = Math.min(x1, Math.min(x2, x3)), res = Integer.MAX_VALUE;
        if (minDiff == x1)
            res = Math.min(res, a1);
        if (minDiff == x2)
            res = Math.min(res, a2);
        if (minDiff == x3)
            res = Math.min(res, a3);
        return dp[n][target] = res;
    }

    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        dp = new int[toppingCosts.length][target];
        for (int i[] : dp)
            Arrays.fill(i, -1);
        int res = 1000000;
        for (int i = 0; i < baseCosts.length; i++) {
            int a = baseCosts[i] + solve(toppingCosts, 0, target - baseCosts[i]);
            if (Math.abs(res - target) > Math.abs(target - a))
                res = a;
            if (Math.abs(res - target) == Math.abs(target - a))
                res = Math.min(res, a);
        }
        return res;
    }
}
