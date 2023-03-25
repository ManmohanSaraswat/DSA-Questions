import java.util.*;

public class SmallestMissingNonnegativeIntegerAfterOperations {
    public int findSmallestInteger(int[] nums, int k) {
        Queue<Integer> que = new PriorityQueue<>((a, b) -> Integer.compare(a, b));
        int[] arr = new int[k];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % k < 0)
                arr[nums[i] % k + k]++;
            else
                arr[nums[i] % k]++;
        }
        for (int i = 0; i < k; i++) {
            if (arr[i] > 0) {
                int l = i;
                while (arr[i] > 0) {
                    que.offer(l);
                    l += k;
                    arr[i]--;
                }
            }
        }
        int prev = que.poll();
        if (prev != 0)
            return 0;
        while (!que.isEmpty()) {
            int cur = que.poll();
            if (prev == cur)
                que.offer(cur + k);
            else if (cur - prev > 1)
                return prev + 1;
            else
                prev = cur;
        }
        return prev + 1;
    }
}
