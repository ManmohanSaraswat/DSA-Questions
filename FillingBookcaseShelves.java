import java.util.Arrays;

public class FillingBookcaseShelves {
    int[] dp;

    private int solve(int[][] books, int shelfWidth, int n) {
        if (n == books.length)
            return 0;
        if (dp[n] != -1)
            return dp[n];
        int width = 0, max = 0, res = Integer.MAX_VALUE, i = n;
        while (i < books.length && width + books[i][0] <= shelfWidth) {
            width += books[i][0];
            max = Math.max(max, books[i][1]);
            res = Math.min(res, max + solve(books, shelfWidth, i + 1));
            i++;
        }
        return dp[n] = res;
    }

    public int minHeightShelves(int[][] books, int shelfWidth) {
        dp = new int[books.length + 1];
        Arrays.fill(dp, -1);
        return solve(books, shelfWidth, 0);
    }

    public int minHeightShelvesTabular(int[][] books, int shelfWidth) {
        int n = books.length;
        dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int width = 0, max = 0, res = Integer.MAX_VALUE, j = i;
            while (j >= 1 && width + books[j - 1][0] <= shelfWidth) {
                width += books[j - 1][0];
                max = Math.max(max, books[j - 1][1]);
                res = Math.min(res, max + dp[j - 1]);
                j--;
            }
            dp[i] = res;
        }
        return dp[n];
    }
}
