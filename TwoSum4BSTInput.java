import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left, right;
}

public class TwoSum4BSTInput {
    static TreeNode root;
    static int n;

    public boolean find(TreeNode head, int target, TreeNode temp) {
        if (head == null)
            return false;
        if (head.val == target && head != temp)
            return true;
        return target < head.val ? find(head.left, target, temp) : find(head.right, target, temp);
    }

    public boolean findForEveryNode(TreeNode head) {
        if (head == null)
            return false;
        return find(root, n - head.val, head) || findForEveryNode(head.left) || findForEveryNode(head.right);
    }

    public boolean findTargetUsingDFS(TreeNode head, int k) {
        root = head;
        n = k;
        return findForEveryNode(head);
    }

    static List<Integer> sortedArray;

    public void inOrderTraversal(TreeNode head) {
        if (head == null)
            return;
        inOrderTraversal(head.left);
        sortedArray.add(head.val);
        inOrderTraversal(head.right);
    }

    public boolean findTargetUsingInorderTraversal(TreeNode head, int k) {
        sortedArray = new ArrayList<>();
        inOrderTraversal(head);
        int start = 0, end = sortedArray.size() - 1;
        while (start < end) {
            int sum = sortedArray.get(start) + sortedArray.get(end);
            if (sum == k)
                return true;
            if (sum < k)
                start++;
            else
                end--;
        }
        return false;
    }
}
