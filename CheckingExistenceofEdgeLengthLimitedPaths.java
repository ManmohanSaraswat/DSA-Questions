import java.util.Arrays;

public class CheckingExistenceofEdgeLengthLimitedPaths {
    int[] set;

    private int findParent(int u) {
        if (set[u] == u)
            return u;
        return set[u] = findParent(set[u]);
    }

    private void union(int a, int b) {
        int p1 = findParent(a), p2 = findParent(b);
        if (p1 != p2) {
            set[b] = p1;
        }
        set[p2] = p1;
    }

    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        int[][] pQueries = new int[queries.length][4];
        boolean[] res = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            pQueries[i][0] = queries[i][0];
            pQueries[i][1] = queries[i][1];
            pQueries[i][2] = queries[i][2];
            pQueries[i][3] = i;
        }
        Arrays.sort(pQueries, (a, b) -> Integer.compare(a[2], b[2]));
        Arrays.sort(edgeList, (a, b) -> Integer.compare(a[2], b[2]));
        set = new int[n];
        for (int i = 0; i < set.length; i++)
            set[i] = i;
        int edge = 0;
        for (int i = 0; i < queries.length; i++) {
            while (edge < edgeList.length && edgeList[edge][2] < pQueries[i][2]) {
                union(edgeList[edge][0], edgeList[edge][1]);
                edge++;
            }
            res[pQueries[i][3]] = findParent(pQueries[i][0]) == findParent(pQueries[i][1]);
        }
        return res;
    }
}
