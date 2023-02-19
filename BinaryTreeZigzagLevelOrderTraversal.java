import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        res.add(Arrays.asList(root.val));
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(null);
        que.offer(root);
        int curLevel = 0;
        while (!que.isEmpty()) {
            TreeNode cur = que.poll();
            if (cur == null) {
                if (que.peek() == null)
                    break;
                que.offer(null);
                curLevel++;
                res.add(new ArrayList<>());
            } else {
                if (cur.left != null) {
                    que.offer(cur.left);
                    res.get(curLevel).add(cur.left.val);
                }
                if (cur.right != null) {
                    que.offer(cur.right);
                    res.get(curLevel).add(cur.right.val);
                }
            }
        }
        int n = res.size();
        for (int i = 1; i < n; i += 2) {
            Collections.reverse(res.get(i));
        }
        res.remove(n - 1);
        return res;
    }

    private void solve(TreeNode root, List<List<Integer>> res, int level){
        if(root == null) return;
        if(level == res.size())
            res.add(new ArrayList());
        if(level % 2 != 0)
            res.get(level).add(0, root.val);
        else  
            res.get(level).add(root.val);
        solve(root.left, res, level + 1);
        solve(root.right, res, level + 1);
    }
    public List<List<Integer>> zigzagLevelOrderEfficient(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        solve(root, res, 0);
        return res;
    }
}
