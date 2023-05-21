public class IsGraphBipartite {
    private boolean solve(int[][] graph, int n, int cur, int colors[]) {
        if (colors[n] == cur)
            return false;
        if (cur == 1)
            colors[n] = 2;
        else
            colors[n] = 1;
        int[] neighbors = graph[n];
        for (int neighbor : neighbors) {
            if (colors[neighbor] == colors[n])
                return false;
            if (colors[neighbor] == 0 && !solve(graph, neighbor, colors[n], colors))
                return false;
        }
        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int colors[] = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (colors[i] == 0 && !solve(graph, i, 1, colors))
                return false;
        }
        return true;
    }
}
