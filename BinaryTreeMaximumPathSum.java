import java.util.HashMap;
import java.util.Map;

public class BinaryTreeMaximumPathSum {
    static int res;
    private static void helper(TreeNode root){
        if(root == null) return;
        solve(root);
        helper(root.left);
        helper(root.right);
    }
    private static int solve(TreeNode root){
        if(root == null) return 0;
        int left = solve(root.left);
        int right = solve(root.right);
        int ans = Math.max(root.val + left + right, Math.max(root.val, root.val + Math.max(left, right)));
        res = Math.max(res, ans);
        return Math.max(root.val, root.val + Math.max(left, right));
    }
    public int maxPathSum(TreeNode root) {
        res = Integer.MIN_VALUE;
        helper(root);
        return res;
    }
}
class BinaryTreeMaximumPathSumEfficient{
    static int res;
    static Map<TreeNode, Integer> dp;
    private static void helper(TreeNode root){
        if(root == null) return;
        solve(root);
        helper(root.left);
        helper(root.right);
    }
    private static int solve(TreeNode root){
        if(root == null) return 0;
        if(dp.containsKey(root)) return dp.get(root);
        int left = solve(root.left);
        int right = solve(root.right);
        int ans = Math.max(root.val + left + right, Math.max(root.val, root.val + Math.max(left, right)));
        res = Math.max(res, ans);
        dp.put(root, Math.max(root.val, root.val + Math.max(left, right)));
        return dp.get(root);
    }
    public int maxPathSum(TreeNode root) {
        res = Integer.MIN_VALUE;
        dp = new HashMap<>();
        helper(root);
        return res;
    }
}
