import java.util.Arrays;

public class RemoveMaxNumberofEdgestoKeepGraphFullyTraversable {
    private static class DSU {
        private int[] set;

        public DSU(int n) {
            set = new int[n];
            for (int i = 0; i < n; i++)
                set[i] = i;
        }

        private int findParent(int u) {
            if (set[u] == u)
                return u;
            return set[u] = findParent(set[u]);
        }

        public boolean union(int a, int b) {
            int p1 = findParent(a), p2 = findParent(b);
            if (p1 == p2)
                return false;
            set[b] = p1;
            set[p2] = p1;
            return true;
        }

        public boolean isConnected() {
            int cur = findParent(0);
            for (int i = 1; i < set.length; i++)
                if (cur != findParent(i))
                    return false;
            return true;
        }
    }

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        Arrays.sort(edges, (a, b) -> Integer.compare(b[0], a[0]));
        DSU alice = new DSU(n);
        DSU bob = new DSU(n);
        int res = 0;
        for (int edge[] : edges) {
            edge[1]--;
            edge[2]--;
            if (edge[0] == 3) {
                if (alice.union(edge[1], edge[2])) {
                    bob.union(edge[1], edge[2]);
                } else
                    res++;
            } else if (edge[0] == 2) {
                if (!bob.union(edge[1], edge[2]))
                    res++;
            } else {
                if (!alice.union(edge[1], edge[2]))
                    res++;
            }
        }
        if (!alice.isConnected() || !bob.isConnected())
            return -1;
        return res;
    }
}
