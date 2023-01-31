import java.util.PriorityQueue;
import java.util.Queue;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Queue<int[]> que = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        int res[] = new int[nums.length - k + 1];
        for(int i = 0; i < nums.length; i++){
            que.offer(new int[]{nums[i], i});
            if(i < k - 1) continue;
            while(que.peek()[1] < i - k + 1)
                que.poll();
            res[i - k + 1] = que.peek()[0];
        }
        return res;
    }
}
