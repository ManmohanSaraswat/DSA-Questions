import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeSet;

public class MinimumNumberofVisitedCellsinaGrid {
    static class Pair {
        int x, y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public int minimumVisitedCells(int[][] grid) {
        int n = grid.length, m = grid[0].length, level = 0;
        TreeSet<Integer> rows[] = new TreeSet[n], cols[] = new TreeSet[m];
        for(int i = 0; i < n; i++){
            rows[i] = new TreeSet<>();
            for(int j = 0; j < m; j++) rows[i].add(j);
        }
        for(int j = 0; j < m; j++){
            cols[j] = new TreeSet<>();
            for(int i = 0; i < n; i++) cols[j].add(i);
        }
        Queue<Pair> que = new LinkedList<>();
        que.add(new Pair(0, 0));
        while(!que.isEmpty()){
            int qSize = que.size();
            for(int p = 0; p < qSize; p++){
                Pair cur = que.poll();
                int x = cur.x, y = cur.y;
                if(x == n - 1 && y == m - 1) return level + 1;
                var rSet = rows[x].subSet(y + 1, Math.min(m, y + grid[x][y] + 1));
                var cSet = cols[y].subSet(x + 1, Math.min(n, x + grid[x][y] + 1));
                rSet.forEach(k -> que.add(new Pair(x, k)));
                cSet.forEach(k -> que.add(new Pair(k, y)));
                rSet.clear();
                cSet.clear();
            }
            level ++;
        }
        return -1;
    }
}
