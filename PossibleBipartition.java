import java.util.*;

public class PossibleBipartition {
    private boolean solve(List<List<Integer>> graph, int[] color, int i) {
        Queue<Integer> que = new LinkedList<>();
        que.offer(i);
        color[i] = 0;
        while (!que.isEmpty()) {
            int n = que.poll();
            int col = color[n] ^ 1;
            List<Integer> vals = graph.get(n);
            for (int val : vals) {
                if (color[val] == -1) {
                    color[val] = col;
                    que.offer(val);
                } else if (color[val] != col)
                    return false;
            }
        }
        return true;
    }

    public boolean possibleBipartitionBFS(int n, int[][] dislikes) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            graph.add(new ArrayList<>());
        for (int[] dislike : dislikes) {
            graph.get(dislike[0]).add(dislike[1]);
            graph.get(dislike[1]).add(dislike[0]);
        }
        int[] color = new int[n + 1];
        Arrays.fill(color, -1);
        for (int i = 1; i <= n; i++)
            if (color[i] == -1 && !solve(graph, color, i))
                return false;
        return true;
    }

    private boolean solve(List<List<Integer>> graph, int[] color, int i, int apply) {
        color[i] = apply;
        List<Integer> vals = graph.get(i);
        boolean ans = true;
        for (int val : vals) {
            if (color[val] == -1) {
                color[val] = apply ^ 1;
                ans = ans && solve(graph, color, val, apply ^ 1);
            } else if (color[val] != (apply ^ 1))
                return false;
        }
        return ans;
    }

    public boolean possibleBipartitionDFS(int n, int[][] dislikes) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            graph.add(new ArrayList<>());
        for (int[] dislike : dislikes) {
            graph.get(dislike[0]).add(dislike[1]);
            graph.get(dislike[1]).add(dislike[0]);
        }
        int[] color = new int[n + 1];
        Arrays.fill(color, -1);
        for (int i = 1; i <= n; i++)
            if (color[i] == -1 && !solve(graph, color, i, 0))
                return false;
        return true;
    }
}