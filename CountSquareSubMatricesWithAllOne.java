public class CountSquareSubMatricesWithAllOne {

    public int expandSquare(int[][] matrix, int i, int j) {
        int n = matrix.length;
        int m = matrix[0].length;
        int count = 0, reachI = i, reachJ = j;
        while (reachI < n && reachJ < m) {
            boolean flag = true;

            for (int x = i; x <= reachI; x++) {
                if (matrix[x][reachJ] != 1) {
                    flag = false;
                    break;
                }
            }
            for (int x = j; x <= reachJ; x++) {
                if (matrix[reachI][x] != 1) {
                    flag = false;
                    break;
                }
            }
            if (flag == false)
                break;
            count++;
            reachI++;
            reachJ++;
        }

        return count;
    }

    public int countSquares(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int ans = 0;
        int dp[][] = new int[n][m];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                dp[i][j] = matrix[i][j];
                if (i != n - 1 && j != m - 1 && matrix[i][j] != 0)
                    dp[i][j] += Math.min(dp[i + 1][j + 1], Math.min(dp[i + 1][j], dp[i][j + 1]));
                // temp = expandSquare(matrix, i, j);
                // System.out.print(temp + " ");
                // ans += temp;
                ans += dp[i][j];
            }
        }
        return ans;
    }
}
