import java.util.*;

public class MinimumScoreofaPathBetweenTwoCities {
    int[] set;

    private int findParent(int u) {
        if (set[u] == u)
            return u;
        return set[u] = findParent(set[u]);
    }

    private void union(int a, int b) {
        int p1 = findParent(a);
        int p2 = findParent(b);
        if (p1 != p2) {
            if (p1 < p2)
                set[b] = p1;
            else
                set[a] = p2;
        }
        if (p1 < p2)
            set[p2] = p1;
        else
            set[p1] = p2;
    }

    public int minScoreEfficient(int n, int[][] roads) {
        set = new int[n + 1];
        int res = Integer.MAX_VALUE;
        for (int i = 0; i <= n; i++)
            set[i] = i;
        for (int road[] : roads) {
            union(road[0], road[1]);
        }
        for (int road[] : roads) {
            int p1 = findParent(road[0]);
            int p2 = findParent(road[1]);
            if (p1 == p2 && p1 == 1) {
                res = Math.min(road[2], res);
            }
        }
        return res;
    }

    private int bfs(List<List<int[]>> graph, int n){
        boolean[] visited = new boolean[n];
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{0, Integer.MAX_VALUE});
        int res = Integer.MAX_VALUE;
        while(!que.isEmpty()){
            int []source = que.poll();
            visited[source[0]] = true;
            res = Math.min(res, source[1]);
            for(int[] neighbour: graph.get(source[0])){
                if(visited[neighbour[0]]) continue;
                que.offer(new int[]{neighbour[0], neighbour[1]});
            }
        }
        return res;
    }
    public int minScore(int n, int[][] roads) {
        List<List<int[]>> lst = new ArrayList<>();
        for(int i = 0; i < n; i++) lst.add(new ArrayList<>());
        for(int road[]: roads){
            lst.get(road[0] - 1).add(new int[]{road[1] - 1, road[2]});
            lst.get(road[1] - 1).add(new int[]{road[0] - 1, road[2]});
        }
        return bfs(lst, n);
    }

}
