public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int up = 0, left = 0, right = n - 1, down = n - 1, count = 1, N = n * n;
        while (up < n && left < n && right >= 0 && down >= 0) {
            for (int i = left; i <= right && count <= N; i++)
                res[up][i] = count++;
            for (int i = up + 1; i < down && count <= N; i++)
                res[i][right] = count++;
            for (int i = right; i >= left && count <= N; i--)
                res[down][i] = count++;
            for (int i = down - 1; i > up && count <= N; i--)
                res[i][left] = count++;
            up++;
            left++;
            right--;
            down--;
        }
        return res;
    }
}
