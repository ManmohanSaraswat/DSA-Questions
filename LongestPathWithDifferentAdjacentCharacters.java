import java.util.*;

public class LongestPathWithDifferentAdjacentCharacters {
    Map<Integer, List<Integer>> tree;
    int res;

    private int solve(int n, char[] arr) {
        if (!tree.containsKey(n))
            return 1;
        List<Integer> childs = tree.get(n);
        List<Integer> toAdd = new ArrayList<>();
        for (int child : childs) {
            int ans = solve(child, arr);
            if (arr[n] != arr[child])
                toAdd.add(ans);
        }
        Collections.sort(toAdd, (a, b) -> b - a);
        int x = toAdd.size();
        int ans = 0;
        if (x == 0)
            ans = 1;
        else if (x == 1)
            ans = 1 + toAdd.get(0);
        else {
            res = Math.max(res, 1 + toAdd.get(0) + toAdd.get(1));
            ans = 1 + Math.max(toAdd.get(0), toAdd.get(1));
        }
        res = Math.max(ans, res);
        return ans;
    }

    public int longestPath(int[] parent, String s) {
        if (parent.length == 1)
            return 1;
        tree = new HashMap<>();
        char[] arr = s.toCharArray();
        res = 0;
        for (int i = 1; i < parent.length; i++) {
            List<Integer> lst = tree.getOrDefault(parent[i], new ArrayList<>());
            lst.add(i);
            tree.put(parent[i], lst);
        }
        solve(0, arr);
        return res;
    }
}
