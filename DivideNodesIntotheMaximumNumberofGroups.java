import java.util.*;

public class DivideNodesIntotheMaximumNumberofGroups {
    int[] set;

    private int findParent(int a) {
        if (set[a] == a)
            return a;
        return set[a] = findParent(set[a]);
    }

    private void union(int a, int b) {
        int p1 = findParent(a);
        int p2 = findParent(b);
        if (p1 != p2) {
            set[b] = p1;
        }
        set[p2] = p1;
    }

    private int bfs(List<List<Integer>> graph, int cur, int n) {
        Queue<Integer> que = new LinkedList<>();
        que.offer(cur);
        int groups[] = new int[n], maxGroup = 0;
        Arrays.fill(groups, -1);
        groups[cur] = 0;
        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                int current = que.poll();
                List<Integer> neighbours = graph.get(current);
                for (int neighbour : neighbours) {
                    if (groups[neighbour] == -1) {
                        que.offer(neighbour);
                        groups[neighbour] = maxGroup + 1;
                    } else if (Math.abs(maxGroup - groups[neighbour]) != 1)
                        return -1;
                }
            }
            maxGroup++;
        }
        return maxGroup;
    }

    public int magnificentSets(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        set = new int[n];
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            set[i] = i;
        }
        for (int[] edge : edges) {
            graph.get(edge[0] - 1).add(edge[1] - 1);
            graph.get(edge[1] - 1).add(edge[0] - 1);
            union(edge[0] - 1, edge[1] - 1);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int p = findParent(i);
            int x = bfs(graph, i, n);
            map.put(p, Math.max(map.getOrDefault(p, -1), x));
        }
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == -1)
                return -1;
            res += entry.getValue();
        }
        return res;
    }
}
