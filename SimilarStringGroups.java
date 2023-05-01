import java.util.HashSet;
import java.util.Set;

public class SimilarStringGroups {
    int[] set;

    private void union(int a, int b) {
        int p1 = findParent(a), p2 = findParent(b);
        if (p1 != p2) {
            set[b] = p1;
        }
        set[p2] = p1;
    }

    private int findParent(int u) {
        if (set[u] == u)
            return u;
        return set[u] = findParent(set[u]);
    }

    private boolean check(String a, String b) {
        char[] arr = a.toCharArray();
        char[] brr = b.toCharArray();
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == brr[i]) {
                count++;
            }
        }
        if (arr.length - count == 0 || arr.length - count == 2)
            return true;
        return false;
    }

    public int numSimilarGroups(String[] strs) {
        set = new int[strs.length];
        for (int i = 0; i < set.length; i++)
            set[i] = i;
        for (int i = 0; i < set.length; i++) {
            for (int j = i + 1; j < set.length; j++) {
                if (check(strs[i], strs[j])) {
                    union(i, j);
                }
            }
        }
        Set<Integer> hSet = new HashSet<>();
        for (int i = 0; i < set.length; i++) {
            findParent(i);
            hSet.add(set[i]);
        }
        return hSet.size();
    }
}
