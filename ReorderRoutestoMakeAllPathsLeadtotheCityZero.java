import java.util.*;

public class ReorderRoutestoMakeAllPathsLeadtotheCityZero {
    private int bfs(List<Set<Integer>> graph, int n, List<List<Integer>> g) {
        Queue<Integer> que = new LinkedList<>();
        boolean[] visited = new boolean[n];
        que.offer(0);
        int count = 0;
        while (!que.isEmpty()) {
            int cur = que.poll();
            visited[cur] = true;
            List<Integer> neighbours = g.get(cur);
            for (int neighbour : neighbours) {
                if (visited[neighbour])
                    continue;
                if (graph.get(cur).contains(neighbour))
                    count++;
                que.offer(neighbour);
            }
        }
        return count;
    }

    public int minReorder(int n, int[][] connections) {
        List<Set<Integer>> graph = new ArrayList<>();
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new HashSet<>());
            g.add(new ArrayList<>());
        }
        for (int[] connection : connections) {
            graph.get(connection[0]).add(connection[1]);
            g.get(connection[1]).add(connection[0]);
            g.get(connection[0]).add(connection[1]);
        }
        return bfs(graph, n, g);
    }
}
