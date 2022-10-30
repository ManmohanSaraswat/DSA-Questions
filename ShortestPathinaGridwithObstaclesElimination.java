import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathinaGridwithObstaclesElimination {
    int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    public int shortestPath(int[][] grid, int k) {
        int n = grid.length, m = grid[0].length;
        boolean[][][] traversed = new boolean[n][m][k + 1];
        Queue<int[]> que = new LinkedList<>();
        traversed[0][0][0] = true;
        que.offer(new int[] { 0, 0, 0, 0 });
        while (que.isEmpty() == false) {
            int[] coor = que.poll();
            if (coor[0] == n - 1 && coor[1] == m - 1)
                return coor[3];
            for (int[] dir : dirs) {
                int nextRow = coor[0] + dir[0];
                int nextCol = coor[1] + dir[1];
                if (nextRow < 0 || nextCol < 0 || nextRow == n || nextCol == m)
                    continue;
                int nextK = coor[2] + grid[nextRow][nextCol];
                if (nextK <= k && traversed[nextRow][nextCol][nextK] == false) {
                    que.offer(new int[] { nextRow, nextCol, nextK, coor[3] + 1 });
                    traversed[nextRow][nextCol][nextK] = true;
                }
            }
        }
        return -1;
    }
}
