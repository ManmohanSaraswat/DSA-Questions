import java.util.HashMap;
import java.util.Map;

public class FirstCompletelyPaintedRoworColumn {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int[] rows = new int[mat.length];
        int[] cols = new int[mat[0].length];
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < rows.length; i++) {
            for (int j = 0; j < cols.length; j++) {
                map.put(mat[i][j], new int[] { i, j });
                rows[i] += mat[i][j];
                cols[j] += mat[i][j];
            }
        }
        for (int i = 0; i < arr.length; i++) {
            int[] cur = map.get(arr[i]);
            rows[cur[0]] -= arr[i];
            cols[cur[1]] -= arr[i];
            if (rows[cur[0]] == 0 || cols[cur[1]] == 0)
                return i;
        }
        return -1;
    }
}
