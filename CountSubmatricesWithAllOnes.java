public class CountSubmatricesWithAllOnes {

    private int haveAllOne(int[][] mat, int i, int j) {
        int n = mat.length, m = mat[0].length, count = 0, bound = m;
        for (int x = i; x < n; x++) {
            for (int y = j; y < bound; y++) {
                if (mat[x][y] == 1) {
                    count++;
                } else
                    bound = y;
            }
        }
        return count;
    }

    public int numSubmat(int[][] mat) {
        int count = 0, n = mat.length, m = mat[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0)
                    continue;
                count += haveAllOne(mat, i, j);
            }
        }
        return count;
    }

    public int numSubmatEfficient(int[][] mat) {
        int n = mat.length, m = mat[0].length, count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (mat[i][j] == 0)
                    continue;
                mat[i][j] += mat[i][j - 1];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0)
                    continue;
                int min = Integer.MAX_VALUE;
                for (int k = i; k < n; k++)
                    count += min = Math.min(mat[k][j], min);
            }
        }
        return count;
    }
}
