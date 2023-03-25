import java.util.*;

public class CheckKnightTourConfiguration {
    private int[][] dirs = new int[][] { { -1, -2 }, { -2, -1 }, { -1, 2 }, { -2, 1 }, { 1, -2 }, { 2, -1 }, { 2, 1 },
            { 1, 2 } };
    private Map<Integer, int[]> map;

    private boolean solve(int[][] grid) {
        int n = grid.length * grid.length;
        int[] prev = map.get(0);
        for (int i = 1; i < n; i++) {
            int[] cur = map.get(i);
            boolean flag = true;
            for (int dir[] : dirs) {
                if (prev[0] + dir[0] == cur[0] && prev[1] + dir[1] == cur[1]) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                return false;
            prev = cur;
        }
        return true;

    }

    public boolean checkValidGrid(int[][] grid) {
        if (grid[0][0] != 0)
            return false;
        map = new HashMap<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                map.put(grid[i][j], new int[] { i, j });
            }
        }
        return solve(grid);
    }
}
