import java.util.*;

public class NumberofOperationstoMakeNetworkConnected {
    int[] set;

    private int findParent(int a) {
        if (set[a] == a)
            return a;
        return set[a] = findParent(set[a]);
    }

    private boolean union(int a, int b) {
        int p1 = findParent(a);
        int p2 = findParent(b);
        if (p1 != p2) {
            set[b] = p1;
        } else {
            return true;
        }
        set[p2] = p1;
        return false;
    }

    public int makeConnected(int n, int[][] connections) {
        int extraCables = 0;
        set = new int[n];
        Set<Integer> hSet = new HashSet<>();
        for (int i = 0; i < n; i++)
            set[i] = i;
        for (int[] connection : connections) {
            if (union(connection[0], connection[1]))
                extraCables++;
        }
        for (int i = 0; i < n; i++) {
            hSet.add(findParent(i));
        }
        int x = hSet.size() - 1;
        if (x > extraCables)
            return -1;
        return x;
    }
}
