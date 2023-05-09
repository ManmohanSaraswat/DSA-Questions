import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    int[][] path = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public List<Integer> spiralOrder(int[][] matrix) {
        int curPath = 0, n = matrix.length, m = matrix[0].length, N = n * m, i = 0, j = -1, x = 0;
        List<Integer> res = new ArrayList<>();
        while (x < N) {
            i = i + path[curPath][0];
            j = j + path[curPath][1];
            if (i < 0 || j < 0 || i >= n || j >= m || matrix[i][j] == 200) {
                i = i - path[curPath][0];
                j = j - path[curPath][1];
                curPath = (curPath + 1) % 4;
                continue;
            }
            res.add(matrix[i][j]);
            matrix[i][j] = 200;
            x++;
        }
        return res;
    }

    public List<Integer> spiralOrderBetter(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length, up = 0, left = 0, right = m - 1, down = n - 1;
        List<Integer> res = new ArrayList<>();
        while (up < n && left < m && right >= 0 && down >= 0) {
            for (int i = left; i <= right && res.size() < n * m; i++) {
                res.add(matrix[up][i]);
            }
            for (int i = up + 1; i < down && res.size() < n * m; i++) {
                res.add(matrix[i][right]);
            }
            for (int i = right; i >= left && res.size() < n * m; i--) {
                res.add(matrix[down][i]);
            }
            for (int i = down - 1; i > up && res.size() < n * m; i--) {
                res.add(matrix[i][left]);
            }
            up++;
            left++;
            right--;
            down--;
        }
        return res;
    }
}
