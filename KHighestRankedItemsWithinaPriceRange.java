import java.util.*;

public class KHighestRankedItemsWithinaPriceRange {
    int[][] dirs = new int[][] { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };

    private List<int[]> solve(int[][] grid, int[] pricing, int[] start, int k) {
        int n = grid.length, m = grid[0].length;
        List<int[]> res = new ArrayList<>();
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[] { start[0], start[1], 0 });
        visited[start[0]][start[1]] = true;
        if (grid[start[0]][start[1]] >= pricing[0] && grid[start[0]][start[1]] <= pricing[1])
            res.add(new int[] { start[0], start[1], grid[start[0]][start[1]], 0 });
        while (!que.isEmpty()) {
            int[] coor = que.poll();
            for (int[] dir : dirs) {
                int x = dir[0] + coor[0];
                int y = dir[1] + coor[1];
                if (x < 0 || y < 0 || x == n || y == m || visited[x][y] || grid[x][y] == 0)
                    continue;
                visited[x][y] = true;
                que.add(new int[] { x, y, coor[2] + 1 });
                if (grid[x][y] <= pricing[1] && grid[x][y] >= pricing[0])
                    res.add(new int[] { x, y, grid[x][y], coor[2] + 1 });
            }
        }
        return res;
    }

    public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
        List<int[]> lst = solve(grid, pricing, start, k);
        Collections.sort(lst, (a, b) -> {
            if (a[3] != b[3])
                return a[3] - b[3];
            if (a[2] != b[2])
                return a[2] - b[2];
            if (a[0] != b[0])
                return a[0] - b[0];
            return a[1] - b[1];
        });
        int n = Math.min(k, lst.size());
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            res.add(Arrays.asList(lst.get(i)[0], lst.get(i)[1]));
        }
        return res;
    }
}
