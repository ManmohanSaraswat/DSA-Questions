import java.util.Arrays;

public class MaximumCompactabilityScore {
    int finalAns;
    int[][] students;
    int[][] mentors;
    int[][] dp;

    public void solve(int s, int bit, int score) {
        if (s == students.length) {
            finalAns = Math.max(score, finalAns);
            return;
        }
        for (int i = 0; i < mentors.length; i++) {
            if ((bit & (1 << i)) == 0)
                solve(s + 1, (bit | (1 << i)), score + calculateScore(s, i));
        }
    }

    public int maxCompatibilitySum(int[][] s, int[][] m) {
        students = s;
        mentors = m;
        finalAns = Integer.MIN_VALUE;
        solve(0, 0, 0);
        return finalAns;
    }

    private int calculateScore(int student, int mentor) {
        int size = students[student].length, score = 0;
        for (int i = 0; i < size; i++) {
            score += (students[student][i] == mentors[mentor][i]) ? 1 : 0;
        }
        return score;
    }
    public int solveMemoization(int s, int bit) {
        if (s == students.length) {
            return 0;
        }
        if(dp[s][bit] != -1) return dp[s][bit];
        int ans = 0;
        for (int i = 0; i < mentors.length; i++) {
            if((bit & (1 << i)) == 0)
                ans = Math.max(ans, calculateScore(s, i) + solveMemoization(s + 1, (bit | (1 << i))));
        }
        return dp[s][bit] = ans;
    }
    public int maxCompatibilitySumDpMemoizationBitMask(int[][] s, int[][] m) {
        students = s;
        mentors = m;
        dp = new int[9][256];
        for(int[] i: dp)
            Arrays.fill(i, -1);
        return solveMemoization(0, 0);
    }
}