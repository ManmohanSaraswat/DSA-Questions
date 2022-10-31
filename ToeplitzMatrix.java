public class ToeplitzMatrix {
    public boolean isToeplitzMatrixEfficientApproach(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[] arr = matrix[0];
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] != arr[j - 1])
                    return false;
            }
            arr = matrix[i];
        }
        return true;
    }

    public boolean isToeplitzMatrix(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            int x = i + 1, y = 1, temp = matrix[i][0];
            while (x < n && y < m) {
                if (temp != matrix[x][y])
                    return false;
                x++;
                y++;
            }
        }
        for (int i = 1; i < m; i++) {
            int x = 1, y = i + 1, temp = matrix[0][i];
            while (x < n && y < m) {
                if (temp != matrix[x][y])
                    return false;
                x++;
                y++;
            }
        }
        return true;
    }
}
