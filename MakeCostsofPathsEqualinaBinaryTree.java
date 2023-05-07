public class MakeCostsofPathsEqualinaBinaryTree {
    int res = 0;

    private int dfs(int n, int[] cost) {
        if (n >= cost.length) {
            return 0;
        }
        int left = dfs(2 * n + 1, cost);
        int right = dfs(2 * n + 2, cost);
        res += Math.abs(left - right);
        return Math.max(left, right) + cost[n];
    }

    public int minIncrements(int n, int[] cost) {
        res = 0;
        dfs(0, cost);
        return res;
    }
}