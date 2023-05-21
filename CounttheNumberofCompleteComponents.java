import java.util.HashMap;
import java.util.Map;

public class CounttheNumberofCompleteComponents {
    int set[];

    private int findParent(int u) {
        if (set[u] == u)
            return u;
        return set[u] = findParent(set[u]);
    }

    private void union(int a, int b) {
        int p1 = findParent(a);
        int p2 = findParent(b);
        if (p1 != p2) {
            set[b] = p1;
        }
        set[p2] = p1;
    }

    public int countCompleteComponents(int n, int[][] edges) {
        set = new int[n];
        for (int i = 0; i < n; i++)
            set[i] = i;
        for (int[] edge : edges) {
            union(edge[0], edge[1]);
        }
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> mapH = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int p = findParent(i);
            mapH.put(p, mapH.getOrDefault(p, 0) + 1);
        }
        for (int[] edge : edges) {
            int p = findParent(edge[0]);
            map.put(p, map.getOrDefault(p, 0) + 1);
        }
        int res = 0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            int v = mapH.get(e.getKey());
            if ((v * (v - 1)) / 2 == e.getValue())
                res++;
        }
        return res + mapH.size() - map.size();
    }
}
