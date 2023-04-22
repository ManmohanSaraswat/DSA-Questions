public class CountNodesEqualtoAverageofSubtree {
    private int[] solve(TreeNode root) {
        if (root == null)
            return new int[] { 0, 0, 0 };
        int[] left = solve(root.left);
        int[] right = solve(root.right);
        int tot = left[0] + right[0] + 1, res[] = new int[3];
        if (root.val == ((left[1] + right[1] + root.val) / tot))
            res[2]++;
        res[0] = tot;
        res[1] = left[1] + right[1] + root.val;
        res[2] += left[2] + right[2];
        return res;
    }

    public int averageOfSubtree(TreeNode root) {
        return solve(root)[2];
    }
}
