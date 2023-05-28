import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MaximumStrictlyIncreasingCellsinaMatrix {
    public int maxIncreasingCells(int[][] mat) {
        Map<Integer, List<int[]>> map = new TreeMap<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                List<int[]> vals = map.getOrDefault(mat[i][j], new ArrayList<>());
                vals.add(new int[] { i, j });
                map.put(mat[i][j], vals);
            }
        }
        int[] rows = new int[mat.length], cols = new int[mat[0].length];
        int[] r = new int[mat.length], c = new int[mat[0].length];
        for (Map.Entry<Integer, List<int[]>> e : map.entrySet()) {
            for (int[] vals : e.getValue()) {
                int mx = 1 + Math.max(rows[vals[0]], cols[vals[1]]);
                r[vals[0]] = Math.max(r[vals[0]], mx);
                c[vals[1]] = Math.max(c[vals[1]], mx);
            }
            for (int[] vals : e.getValue()) {
                rows[vals[0]] = Math.max(r[vals[0]], rows[vals[0]]);
                cols[vals[1]] = Math.max(c[vals[1]], cols[vals[1]]);
            }
        }
        int max = 0;
        for (int e : rows)
            max = Math.max(e, max);
        for (int e : cols)
            max = Math.max(e, max);
        return max;
    }
}
