import java.util.*;

public class CousinsinBinaryTreeII {
    private TreeNode bfs(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        List<TreeNode> prev = new ArrayList<>();
        List<TreeNode> curLst = new ArrayList<>();
        while (!que.isEmpty()) {
            int n = que.size();
            int sum = 0;
            for (int i = 0; i < n; i++) {
                TreeNode cur = que.poll();
                curLst.add(cur);
                sum += cur.val;
                if (cur.left != null)
                    que.offer(cur.left);
                if (cur.right != null)
                    que.offer(cur.right);
            }
            int x = prev.size(), i = 0, j = 0;
            while (i < x && j < n) {
                TreeNode cur = prev.get(i);
                int prevL = j, prevSm = 0;
                if (cur.left != null && cur.left == curLst.get(j)) {
                    prevSm = curLst.get(j).val;
                    j++;
                }
                if (cur.right != null && cur.right == curLst.get(j)) {
                    prevSm += curLst.get(j).val;
                    j++;
                }
                while (prevL < j) {
                    if (prevSm == 0)
                        prevSm = sum;
                    curLst.get(prevL).val = sum - prevSm;
                    prevL++;
                }
                i++;
            }
            prev = new ArrayList<>(curLst);
            curLst = new ArrayList<>();
        }
        root.val = 0;
        return root;
    }

    public TreeNode replaceValueInTree(TreeNode root) {
        return bfs(root);
    }
}
