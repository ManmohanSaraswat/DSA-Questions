import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {
    private class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    Map<Integer, Node> map;

    private void dfs(Node node) {
        if (!map.containsKey(node.val)) {
            map.put(node.val, new Node(node.val));
            Node cur = map.get(node.val);
            List<Node> neighbors = node.neighbors;
            for (Node neigh : neighbors) {
                dfs(neigh);
                cur.neighbors.add(map.get(neigh.val));
            }
        }
    }

    public Node cloneGraph(Node node) {
        if (node == null)
            return null;
        map = new HashMap<>();
        dfs(node);
        return map.get(node.val);
    }
}
