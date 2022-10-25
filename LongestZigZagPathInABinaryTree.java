public class LongestZigZagPathInABinaryTree {
    int max;
    private int[] solve(TreeNode root){
        if(root == null) return new int[]{-1, -1};
        int[] left = solve(root.left);
        int[] right = solve(root.right);
        int[] ans = new int[]{1 + left[1], 1 + right[0]};
        max = Math.max(max, Math.max(ans[0], ans[1]));
        return ans;
    }
    public int longestZigZag(TreeNode root) {
        max = 0;
        solve(root);
        return max;
    }
}
