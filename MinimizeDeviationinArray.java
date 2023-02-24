import java.util.*;

public class MinimizeDeviationinArray {
    public int minimumDeviation(int[] nums) {
        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int max = Integer.MIN_VALUE, res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int original = nums[i];
            while (nums[i] % 2 == 0)
                nums[i] >>= 1;
            minHeap.offer(new int[] { nums[i], original });
            max = Math.max(max, nums[i]);
        }
        while (minHeap.size() == nums.length) {
            int[] curMin = minHeap.poll();
            res = Math.min(res, max - curMin[0]);
            if (curMin[0] % 2 == 1 || curMin[0] < curMin[1]) {
                curMin[0] *= 2;
                minHeap.offer(curMin);
                max = Math.max(max, curMin[0]);
            }
        }
        return res;
    }
}
