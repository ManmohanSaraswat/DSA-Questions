import java.util.HashMap;
import java.util.Map;

public class PathSumIII {
    static int target, count;
    private static void helper(TreeNode root){
        if(root == null) return;
        solve(root, 0);
        helper(root.left);
        helper(root.right);
    }

    private static void solve(TreeNode root, long curSum){
        if(root == null) return;
        if(target == curSum + root.val){
            count ++;
        }
        solve(root.left, curSum + root.val);
        solve(root.right, curSum + root.val);
    }
    
    public int pathSum(TreeNode root, int targetSum) {
        target = targetSum;
        count = 0;
        helper(root);
        return count;
    }
}
class PathSumIIIEfficient{
    static int target, count;
    static Map<Long, Integer> map;
    private static void solve(TreeNode root, long curSum){
        if(root == null) return;
        curSum += root.val;
        count += map.getOrDefault(curSum - target, 0);
        map.put(curSum, map.getOrDefault(curSum, 0) + 1);
        solve(root.left, curSum);
        solve(root.right, curSum);
        map.put(curSum, map.get(curSum) - 1);
    }
    
    public int pathSum(TreeNode root, int targetSum) {
        target = targetSum;
        count = 0;
        map = new HashMap<>();
        map.put((long) 0, 1);
        solve(root, 0);
        return count;
    }
}