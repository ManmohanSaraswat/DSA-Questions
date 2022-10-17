import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class UniqueBinarySearchTrees2 {
    Map<String, List<TreeNode>> map;

    public List<TreeNode> solve(int start, int end) {
        if (start >= end)
            return Arrays.asList(new TreeNode(start));
        if (map.containsKey(start + "-" + end))
            return map.get(start + "-" + end);
        List<TreeNode> res = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            List<TreeNode> Left = solve(start, i - 1);
            List<TreeNode> Right;
            if (i + 1 > end)
                Right = Arrays.asList(new TreeNode(end));
            else
                Right = solve(i + 1, end);
            for (TreeNode left : Left) {
                for (TreeNode right : Right) {
                    TreeNode root = new TreeNode(i);
                    if (right.val != 0 && right.val > i)
                        root.right = right;
                    if (left.val != 0 && left.val < i)
                        root.left = left;
                    res.add(root);
                }
            }
        }
        map.put(start + "-" + end, res);
        return res;
    }

    public List<TreeNode> generateTrees(int n) {
        map = new HashMap<>();
        return solve(1, n);
    }
}
