public class ConvertSortedArraytoBinarySearchTree {
    private TreeNode solve(int[] nums, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            TreeNode left = solve(nums, start, mid - 1);
            TreeNode right = solve(nums, mid + 1, end);
            TreeNode root = new TreeNode(nums[mid], left, right);
            return root;
        }
        if (start == end) {
            return new TreeNode(nums[start]);
        }
        return null;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return solve(nums, 0, nums.length - 1);
    }
}
