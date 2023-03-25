import java.util.*;

public class MinimumNumberofVerticestoReachAllNodes {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] arr = new int[n];
        for (List<Integer> edge : edges) {
            arr[edge.get(1)]++;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0)
                res.add(i);
        }
        return res;
    }
}
