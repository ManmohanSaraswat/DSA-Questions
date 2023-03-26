import java.util.*;

public class LongestCycleinaGraph {
    static class UsingTopologicalSort {
        List<Integer> order;
        int res;

        private void topologicalSort(int[] edges, int cur, boolean[] visited) {
            if (visited[cur])
                return;
            visited[cur] = true;
            if (edges[cur] != -1)
                topologicalSort(edges, edges[cur], visited);
            order.add(cur);
        }

        private void dfs(int[] edges, int cur, int[] distances, int distance, boolean[] visited) {
            if (visited[cur]) {
                res = Math.max(res, distance - distances[cur] + 1);
            } else {
                visited[cur] = true;
                distances[cur] = distance + 1;
                if (edges[cur] != -1)
                    dfs(edges, edges[cur], distances, distance + 1, visited);
            }
            distances[cur] = distance + 1;
        }

        public int longestCycle(int[] edges) {
            order = new ArrayList<>();
            boolean[] visited = new boolean[edges.length];
            res = -1;
            for (int i = 0; i < edges.length; i++) {
                topologicalSort(edges, i, visited);
            }
            visited = new boolean[edges.length];
            int[] distances = new int[edges.length];
            for (int i : order) {
                if (!visited[i])
                    dfs(edges, i, distances, 0, visited);
            }
            return res > 1 ? res : -1;
        }
    }

    static class UsingSimpleDFS {
        int distances[], res;
        boolean[] visited;

        private boolean solve(int[] edges, int distance, int n) {
            if (edges[n] == -1) {
                return visited[n];
            }
            if (visited[n]) {
                res = Math.max(res, distance + 1 - distances[n]);
                distances[n] = distance + 1;
                return true;
            } else {
                visited[n] = true;
                distances[n] = distance + 1;
                boolean ans = solve(edges, distance + 1, edges[n]);
                if (!ans)
                    visited[n] = false;
                return ans;
            }
        }

        public int longestCycle(int[] edges) {
            distances = new int[edges.length];
            visited = new boolean[edges.length];
            res = -1;
            for (int i = 0; i < edges.length; i++) {
                if (!visited[i])
                    solve(edges, 0, i);
            }
            return res;
        }
    }
}