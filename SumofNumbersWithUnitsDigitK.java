import java.util.ArrayList;
import java.util.List;

public class SumofNumbersWithUnitsDigitK {
    List<Integer> res;

    private void findNum(String prev, int len, int num) {
        if (prev.length() > 4 || Integer.parseInt(prev) > num)
            return;
        res.add(Integer.parseInt(prev));
        for (int i = 0; i <= 9; i++) {
            findNum(i + "" + prev, len + 1, num);
        }
    }

    private int solve(int sum, Integer[] dp) {
        if (sum == 0) {
            return 0;
        }
        if (sum < 0) {
            return Integer.MAX_VALUE;
        }
        if (dp[sum] != null)
            return dp[sum];
        int coins = Integer.MAX_VALUE;
        for (int c : res) {
            if (c == 0)
                continue;
            int result = solve(sum - c, dp);
            if (result != Integer.MAX_VALUE) {
                coins = Integer.min(coins, result + 1);
            }
        }
        return dp[sum] = coins;

    }

    public int minimumNumbers(int num, int k) {
        res = new ArrayList<>();
        findNum("" + k, 1, num);
        Integer[] dp = new Integer[100000];
        int ans = solve(num, dp);
        return ans >= 1000000 ? -1 : ans;
    }
}
