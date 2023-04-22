import java.util.*;

public class DesignGraphWithShortestPathCalculator {
    class Graph {
        List<List<int[]>> graph;
        int N;

        public Graph(int n, int[][] edges) {
            graph = new ArrayList<>();
            N = n;
            for (int i = 0; i < n; i++)
                graph.add(new ArrayList<>());
            for (int[] edge : edges)
                graph.get(edge[0]).add(new int[] { edge[1], edge[2] });
        }

        public void addEdge(int[] edge) {
            graph.get(edge[0]).add(new int[] { edge[1], edge[2] });
        }

        public int shortestPath(int node1, int node2) {
            Queue<int[]> que = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
            boolean[] visited = new boolean[N];
            que.offer(new int[] { node1, 0 });
            int res = Integer.MAX_VALUE;
            while (!que.isEmpty()) {
                int[] cur = que.poll();
                visited[cur[0]] = true;
                if (cur[0] == node2) {
                    return cur[1];
                }
                List<int[]> neighbors = graph.get(cur[0]);
                for (int[] neighbor : neighbors) {
                    if (visited[neighbor[0]])
                        continue;
                    que.offer(new int[] { neighbor[0], cur[1] + neighbor[1] });
                }
            }
            return -1;
        }
    }
}