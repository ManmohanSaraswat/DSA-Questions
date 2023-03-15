import java.util.*;

public class CheckCompletenessofaBinaryTree {
    int H;
    List<TreeNode> lst;

    private int height(TreeNode root) {
        if (root == null)
            return -1;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    private boolean solve(TreeNode root, int curHeight) {
        if (curHeight == H) {
            lst.add(root);
        }
        if (root == null) {
            if (curHeight < H)
                return false;
            return true;
        }
        return solve(root.left, curHeight + 1) && solve(root.right, curHeight + 1);
    }

    public boolean isCompleteTree(TreeNode root) {
        lst = new ArrayList<>();
        H = height(root);
        boolean ans = solve(root, 0), res = false;
        int n = lst.size(), x = n;
        for (int i = 0; i < n; i++) {
            if (lst.get(i) == null) {
                x = i;
                break;
            }
        }
        for (int i = x; i < n; i++) {
            if (lst.get(i) != null)
                return false;
        }
        return ans;
    }

    public boolean isCompleteTreeEfficient(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        boolean isNull = false;
        while (!que.isEmpty()) {
            TreeNode temp = que.poll();
            if (temp == null)
                isNull = true;
            if (isNull && temp != null)
                return false;
            if (temp != null) {
                que.offer(temp.left);
                que.offer(temp.right);
            }
        }
        return true;
    }
}
