import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LargestColorValueinaDirectedGraph {
    public int largestPathValue(String colors, int[][] edges) {
        char[] color = colors.toCharArray();
        int[] inDegrees = new int[color.length];
        int[][] dp = new int[color.length][26];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < color.length; i++)
            graph.add(new ArrayList<>());
        for (int edge[] : edges) {
            graph.get(edge[0]).add(edge[1]);
            inDegrees[edge[1]]++;
        }
        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < color.length; i++) {
            if (inDegrees[i] == 0) {
                que.offer(i);
                dp[i][color[i] - 'a']++;
            }
        }
        int max = 0, count = 0;
        while (!que.isEmpty()) {
            count++;
            int cur = que.poll();
            for (int i = 0; i < 26; i++)
                max = Math.max(max, dp[cur][i]);
            List<Integer> neighbors = graph.get(cur);
            for (int ngh : neighbors) {
                for (int i = 0; i < 26; i++) {
                    dp[ngh][i] = Math.max(dp[ngh][i], (dp[cur][i] + (i == (color[ngh] - 'a') ? 1 : 0)));
                }
                if (--inDegrees[ngh] == 0) {
                    que.offer(ngh);
                }
            }
        }
        return count != color.length ? -1 : max;
    }
}
