import java.util.*;

public class SymmetricTree {
    private boolean solve(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 != null)
            return false;
        if (root1 != null && root2 == null)
            return false;
        if (root1 == null && root2 == null)
            return true;
        if (root1.val != root2.val)
            return false;
        return solve(root1.left, root2.right) && solve(root1.right, root2.left);
    }

    public boolean isSymmetric(TreeNode root) {
        Stack<TreeNode[]> stack = new Stack<>();
        stack.push(new TreeNode[] { root.left, root.right });
        while (!stack.isEmpty()) {
            TreeNode[] cur = stack.pop();
            if (cur[0] == null && cur[1] != null)
                return false;
            if (cur[0] != null && cur[1] == null)
                return false;
            if (cur[0] == null && cur[1] == null)
                continue;
            if (cur[0].val != cur[1].val)
                return false;
            stack.push(new TreeNode[] { cur[0].left, cur[1].right });
            stack.push(new TreeNode[] { cur[0].right, cur[1].left });
        }
        return true;
    }
}