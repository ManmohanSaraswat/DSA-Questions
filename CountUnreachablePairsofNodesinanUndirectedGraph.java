import java.util.*;

public class CountUnreachablePairsofNodesinanUndirectedGraph {
    int set[];

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

    public long countPairs(int n, int[][] edges) {
        set = new int[n];
        for (int i = 0; i < n; i++)
            set[i] = i;
        for (int edge[] : edges) {
            union(edge[0], edge[1]);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int p = findParent(i);
            map.put(p, map.getOrDefault(p, 0) + 1);
        }
        List<Integer> lst = new ArrayList<>(map.values());
        int sum = 0;
        for (int i : lst)
            sum += i;
        long res = 0;
        int x = lst.size();
        for (int i = 0; i < x; i++) {
            sum = sum - lst.get(i);
            res += sum * 1L * lst.get(i);
        }
        return res;
    }
}