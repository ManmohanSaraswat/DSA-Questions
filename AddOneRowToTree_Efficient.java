import java.util.LinkedList;
import java.util.Queue;

public class AddOneRowToTree_Efficient {
    private class TreeNode{
        int val;
        TreeNode left, right;
        TreeNode(){}
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
}
