import java.util.*;

public class KthLargestSuminaBinaryTree {
    Map<Integer, Long> dp;

    private void findTheSum(int curLevel, TreeNode curRoot) {
        if (curRoot == null)
            return;
        dp.put(curLevel, dp.getOrDefault(curLevel, 0L) + curRoot.val);
        findTheSum(curLevel + 1, curRoot.left);
        findTheSum(curLevel + 1, curRoot.right);
    }

    public long kthLargestLevelSum(TreeNode root, int k) {
        dp = new HashMap<>();
        findTheSum(0, root);
        Queue<Long> que = new PriorityQueue<>((a, b) -> Long.compare(b, a));
        for (Map.Entry<Integer, Long> entry : dp.entrySet()) {
            que.offer(entry.getValue());
        }
        if (que.size() < k)
            return -1;
        while (k-- > 1)
            que.poll();
        return que.poll();
    }
}
