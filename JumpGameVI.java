import java.util.*;

public class JumpGameVI {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        Queue<int[]> pQueue = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));
        pQueue.offer(new int[] { n - 1, nums[n - 1] });
        for (int i = nums.length - 2; i >= 0; i--) {
            while (pQueue.peek()[0] > i + k)
                pQueue.poll();
            int cur[] = pQueue.peek();
            pQueue.offer(new int[] { i, cur[1] + nums[i] });
        }
        while (pQueue.peek()[0] != 0)
            pQueue.poll();
        return pQueue.poll()[1];
    }
}
