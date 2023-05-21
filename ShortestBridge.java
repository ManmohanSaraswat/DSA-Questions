import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge {
    int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    Queue<int[]> que;

    private void solve(int[][] grid, int n, int m, boolean[][] visited) {
        if (n < 0 || m < 0 || n == grid.length || m == grid[0].length || grid[n][m] == 0 || visited[n][m])
            return;
        visited[n][m] = true;
        que.offer(new int[] { n, m });
        for (int[] dir : dirs) {
            int x = dir[0] + n, y = dir[1] + m;
            solve(grid, x, y, visited);
        }
    }

    private int bfs(int[][] grid, boolean[][] visited) {
        int res = 0;
        while (!que.isEmpty()) {
            int n = que.size();
            for (int i = 0; i < n; i++) {
                int[] cur = que.poll();
                for (int dir[] : dirs) {
                    int x = cur[0] + dir[0], y = cur[1] + dir[1];
                    if (x < 0 || y < 0 || x == grid.length || y == grid[0].length || visited[x][y])
                        continue;
                    if (grid[x][y] == 1)
                        return res;
                    que.offer(new int[] { x, y });
                    visited[x][y] = true;
                }
            }
            res++;
        }
        return res;
    }

    public int shortestBridge(int[][] grid) {
        que = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    solve(grid, i, j, visited);
                    return bfs(grid, visited);
                }
            }
        }
        return -1;
    }
}