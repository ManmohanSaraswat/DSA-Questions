import java.util.HashMap;
import java.util.Map;

public class HouseRobberIII {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    Map<Map.Entry<TreeNode, Boolean>, Integer> map;

    private int solve(TreeNode root, boolean parentRobbed) {
        if (root == null)
            return 0;
        if (map.containsKey(Map.entry(root, parentRobbed)))
            return map.get(Map.entry(root, parentRobbed));
        int ans;
        if (parentRobbed) {
            ans = solve(root.left, false) + solve(root.right, false);
        } else {
            int willNotRob = solve(root.left, false) + solve(root.right, false);
            int willRob = root.val + solve(root.left, true) + solve(root.right, true);
            ans = Math.max(willNotRob, willRob);
        }
        map.put(Map.entry(root, parentRobbed), ans);
        return ans;
    }

    public int rob(TreeNode root) {
        map = new HashMap<>();
        return Math.max(solve(root, true), solve(root, false));
    }

    Map<TreeNode, Integer> dp;
    private int solve(TreeNode root){
        if(root == null) return 0;
        if(dp.containsKey(root)) return dp.get(root);
        int ans = 0;
        if(root.left != null)
            ans = solve(root.left.left) + solve(root.left.right);
        if(root.right != null)
            ans += solve(root.right.left) + solve(root.right.right);
        ans = Math.max(ans + root.val, solve(root.left) + solve(root.right));
        dp.put(root, ans);
        return ans;
    }
    public int robOptimized(TreeNode root) {
        dp = new HashMap<>();
        return solve(root);
    }
}
