public class MaximumProductofSplittedBinaryTree{
    private static long res;
    private static int totalSum(TreeNode root){
        if(root == null) return 0;
        int left = totalSum(root.left);
        int right = totalSum(root.right);
        return root.val + left + right;
    }
    private static int solve(TreeNode root, int SUM){
        if(root == null) return 0;
        int left = solve(root.left, SUM);
        int right = solve(root.right, SUM);
        int ans = root.val + left + right;
        long sec = SUM - ans;
        res = Math.max(res, ans * sec);
        return ans;
    }
    public int maxProduct(TreeNode root) {
        int sum = totalSum(root);
        res = 0;
        solve(root, sum);
        return (int)(res % 1000000007);
    }
}