import java.util.*;

public class AsFarfromLandasPossible {
    int[][] dirs = new int[][] { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };

    private int solve(Queue<int[]> que, int[][] grid, boolean[][] visited) {
        int n = grid.length, res = Integer.MIN_VALUE;
        while (!que.isEmpty()) {
            int[] coor = que.poll();
            for (int[] dir : dirs) {
                int x = coor[0] + dir[0];
                int y = coor[1] + dir[1];
                if (x < 0 || y < 0 || x == n || y == n || visited[x][y])
                    continue;
                visited[x][y] = true;
                if (grid[x][y] == 0)
                    res = Math.max(res, coor[2] + Math.abs(coor[0] - x) + Math.abs(coor[1] - y));
                que.offer(new int[] { x, y, coor[2] + 1 });
            }
        }
        return res;
    }

    public int maxDistance(int[][] grid) {
        Queue<int[]> que = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid.length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == 1) {
                    que.add(new int[] { i, j, 0 });
                    visited[i][j] = true;
                }
            }
        }
        int res = solve(que, grid, visited);
        if (res < 1)
            return -1;
        return res;
    }
}
