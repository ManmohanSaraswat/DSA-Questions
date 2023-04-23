import java.util.*;

public class CountUnguardedCellsintheGrid {
    boolean[][] visited;
    int[][] dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    private void solve(Queue<int[]> que, int[][] matrix) {
        boolean[][][] curTrix = new boolean[matrix.length][matrix[0].length][4];
        while (!que.isEmpty()) {
            int[] cur = que.poll();
            visited[cur[0]][cur[1]] = true;
            curTrix[cur[0]][cur[1]][cur[2]] = true;
            int x = cur[0] + dirs[cur[2]][0];
            int y = cur[1] + dirs[cur[2]][1];
            if (x < 0 || y < 0 || x == matrix.length || y == matrix[0].length)
                continue;
            if (visited[x][y] && curTrix[x][y][cur[2]])
                continue;
            if (matrix[x][y] != 2) {
                que.offer(new int[] { x, y, cur[2] });
            }
        }
    }

    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        visited = new boolean[m][n];
        Queue<int[]> que = new LinkedList<>();
        int[][] matrix = new int[m][n];
        for (int[] guard : guards) {
            matrix[guard[0]][guard[1]] = 1;
            visited[guard[0]][guard[1]] = true;
            for (int i = 0; i < 4; i++)
                que.offer(new int[] { guard[0], guard[1], i });
        }
        for (int[] wall : walls) {
            visited[wall[0]][wall[1]] = true;
            matrix[wall[0]][wall[1]] = 2;
        }
        solve(que, matrix);
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j])
                    count++;
            }
        }
        return count;
    }
}
