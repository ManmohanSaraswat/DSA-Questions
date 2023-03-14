public class SumRoottoLeafNumbers {
    int sum;

    private void solve(TreeNode root, int n) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            sum += n * 10 + root.val;
            return;
        }
        solve(root.left, n * 10 + root.val);
        solve(root.right, n * 10 + root.val);
    }

    public int sumNumbers(TreeNode root) {
        sum = 0;
        solve(root, 0);
        return sum;
    }
}