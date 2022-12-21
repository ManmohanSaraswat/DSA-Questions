import java.util.HashSet;
import java.util.Set;

public class CycleLengthQueriesinaTree {
    public int[] cycleLengthQueries(int n, int[][] queries) {
        int res[] = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int a = queries[i][0];
            int b = queries[i][1];
            Set<Integer> set = new HashSet<>();
            if (a > b) {
                int temp = a;
                a = b;
                b = temp;
            }
            set.add(a);
            set.add(b);
            while (b >= 1) {
                if (!set.add(b / 2)) {
                    res[i] = set.size();
                    break;
                }
                b /= 2;
            }
            if (b > 0)
                continue;
            boolean flag = false;
            while (a >= 1) {
                if (!set.add(a / 2)) {
                    a = a / 2;
                    while (set.contains(a / 2)) {
                        set.remove(a / 2);
                        a = a / 2;
                    }
                    res[i] = set.size();
                    flag = true;
                    break;
                }
                a /= 2;
            }
            if (flag)
                continue;
            res[i] = set.size();
        }
        return res;
    }
}