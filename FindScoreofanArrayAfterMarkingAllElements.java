import java.util.*;

public class FindScoreofanArrayAfterMarkingAllElements {
    public long findScore(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        Queue<int[]> que = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        for (int i = 0; i < nums.length; i++) {
            que.offer(new int[] { nums[i], i });
        }
        long res = 0;
        while (!que.isEmpty()) {
            int cur[] = que.poll();
            if (visited[cur[1]])
                continue;
            res += cur[0];
            if (cur[1] > 0)
                visited[cur[1] - 1] = true;
            if (cur[1] < nums.length - 1)
                visited[cur[1] + 1] = true;
        }
        return res;
    }
}
