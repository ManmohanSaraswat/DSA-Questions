import java.util.LinkedList;
import java.util.Queue;

public class AddOneRowToTree {
    private class TreeNode{
        int val;
        TreeNode left, right;
        TreeNode(int val){
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1)
            return new TreeNode(val, root, null);
        if(depth == 2){
            root.left = new TreeNode(val, root.left, null);
            root.right = new TreeNode(val, null, root.right);
            return root;
        }
        Queue<TreeNode> que = new LinkedList<>();
        Queue<TreeNode> copy = new LinkedList<>();
        que.add(root); que.add(null); copy.add(root); copy.add(null);
        while(que.isEmpty() == false){
            TreeNode temp = que.poll();
            if(temp == null && que.isEmpty() == false) {
                que.add(null);
                copy.add(null);
            }
            if(temp == null) continue;
            if(temp.left != null) {
                que.add(temp.left);
                copy.add(temp.left);
            }
            if(temp.right != null) {
                que.add(temp.right);
                copy.add(temp.right);
            }
        }
        depth --;
        while(copy.isEmpty() == false){
            TreeNode temp = copy.poll();
            if(temp == null){
                if(depth == 2){
                    while(copy.isEmpty() == false){
                        TreeNode t = copy.poll();
                        if(t == null) break;
                        if(t.left != null){
                            t.left = new TreeNode(val, t.left, null);
                        }else{
                            t.left = new TreeNode(val);
                        }
                        if(t.right != null){
                            t.right = new TreeNode(val, null, t.right);
                        }else{
                            t.right = new TreeNode(val);
                        }
                    }
                    break;
                }
                depth --;
            }
        }
        return root;
    }
    public TreeNode addOneRowEfficient(TreeNode root, int val, int depth) {
        if(depth == 1)
            return new TreeNode(val, root, null);
        if(depth == 2){
            root.left = new TreeNode(val, root.left, null);
            root.right = new TreeNode(val, null, root.right);
            return root;
        }
        depth --;
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root); que.add(null);
        while(que.isEmpty() == false){
            TreeNode temp = que.poll();
            if(temp == null && que.isEmpty() == false) {
                que.add(null);
                if(depth == 2){
                    while(que.isEmpty() == false){
                        TreeNode t = que.poll();
                        if(t == null) break;
                        if(t.left != null){
                            t.left = new TreeNode(val, t.left, null);
                        }else{
                            t.left = new TreeNode(val);
                        }
                        if(t.right != null){
                            t.right = new TreeNode(val, null, t.right);
                        }else{
                            t.right = new TreeNode(val);
                        }
                    }
                    break;
                }
                depth --;
                continue;
            }
            if(temp.left != null) {
                que.add(temp.left);
            }
            if(temp.right != null) {
                que.add(temp.right);
            }
        }
        return root;
    }
    public TreeNode addOneRowMoreEfficient(TreeNode root, int val, int depth) {
        if(depth == 1)
            return new TreeNode(val, root, null);
        if(depth == 2){
            root.left = new TreeNode(val, root.left, null);
            root.right = new TreeNode(val, null, root.right);
            return root;
        }
        if(root.left != null)
            root.left = addOneRowMoreEfficient(root.left, val, depth - 1);
        if(root.right != null)
            root.right = addOneRowMoreEfficient(root.right, val, depth - 1);
        return root;
    }
}