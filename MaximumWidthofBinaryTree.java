import java.util.*;

public class MaximumWidthofBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        root.val = 0;
        que.offer(root);
        int res = 0;
        while (!que.isEmpty()) {
            int n = que.size();
            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                TreeNode cur = que.poll();
                min = Math.min(min, cur.val);
                max = Math.max(max, cur.val);
                int val = cur.val * 2;
                if (cur.left != null) {
                    cur.left.val = val + 1;
                    que.offer(cur.left);
                }
                if (cur.right != null) {
                    cur.right.val = val + 2;
                    que.offer(cur.right);
                }
            }
            res = Math.max(res, max - min + 1);
        }
        return res;
    }
}
