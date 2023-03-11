import java.util.*;

public class CreateBinaryTreeFromDescriptions {
    Map<Integer, int[]> map;

    private TreeNode solve(int val) {
        TreeNode root = new TreeNode(val);
        int[] childs = map.get(val);
        if (childs[0] != 0)
            root.left = solve(childs[0]);
        if (childs[1] != 0)
            root.right = solve(childs[1]);
        return root;
    }

    public TreeNode createBinaryTree(int[][] descriptions) {
        map = new HashMap<>();
        for (int[] description : descriptions) {
            map.putIfAbsent(description[0], new int[3]);
            int[] brr = map.get(description[0]);
            if (description[2] == 1)
                brr[0] = description[1];
            else
                brr[1] = description[1];
            map.put(description[0], brr);
            int[] crr = map.getOrDefault(description[1], new int[3]);
            crr[2] = description[0];
            map.put(description[1], crr);
        }
        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            int zrr[] = entry.getValue();
            if (zrr[2] == 0) {
                return solve(entry.getKey());
            }
        }
        return null;
    }

    public TreeNode createBinaryTreeEfficient(int[][] arr) {
        Map<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int[] i : arr) {
            set.add(i[1]);
            map.putIfAbsent(i[0], new TreeNode(i[0]));
            TreeNode root = map.get(i[0]);
            map.putIfAbsent(i[1], new TreeNode(i[1]));
            if (i[2] == 1) {
                root.left = map.get(i[1]);
            } else {
                root.right = map.get(i[1]);
            }
        }
        for (Map.Entry<Integer, TreeNode> entry : map.entrySet())
            if (!set.contains(entry.getKey()))
                return entry.getValue();
        return null;
    }
}
