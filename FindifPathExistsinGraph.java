import java.util.*;

public class FindifPathExistsinGraph {
    private static boolean bfs(int n, Map<Integer, List<Integer>> graph, int source, int destination) {
        boolean[] visited = new boolean[n];
        Queue<Integer> que = new LinkedList<>();
        que.offer(source);
        while (!que.isEmpty()) {
            int src = que.poll();
            if (src == destination)
                return true;
            visited[src] = true;
            List<Integer> neighbours = graph.get(src);
            for (Integer neighbour : neighbours) {
                if (!visited[neighbour])
                    que.add(neighbour);
            }
        }
        return false;
    }

    private static boolean dfs(int n, Map<Integer, List<Integer>> graph, int source, int destination, boolean[] visited){
        if(source == destination) return true;
        visited[source] = true;
        boolean ans = false;
        List<Integer> neighbours = graph.get(source);
        for(Integer neighbour: neighbours){
            if(!visited[neighbour])
                ans |= dfs(n, graph, neighbour, destination, visited);
        }
        return ans;
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            List<Integer> from = graph.getOrDefault(edges[i][0], new ArrayList<>());
            from.add(edges[i][1]);
            graph.put(edges[i][0], from);
            List<Integer> to = graph.getOrDefault(edges[i][1], new ArrayList<>());
            to.add(edges[i][0]);
            graph.put(edges[i][1], to);
        }
        return bfs(n, graph, source, destination);
        // boolean visited[] = new boolean[n];
        // return dfs(n, graph, source, destination, visited);
    }

    private static int[] set;
    private static int findParent(int vertex){
        if(set[vertex] == vertex){
            return vertex;
        }
        return set[vertex] = findParent(set[vertex]);
    }
    private static void combine(int a, int b){
        int par1 = findParent(a);
        int par2 = findParent(b);
        if(par1 != par2)
            set[par2] = par1;
    }
    public boolean validPathEfficient(int n, int[][] edges, int source, int destination) {
        set = new int[n];
        for(int i = 0; i < n; i++) set[i] = i;
        for(int[] edge: edges){
            combine(edge[0], edge[1]);
        }
        return findParent(source) == findParent(destination);
    }
}
