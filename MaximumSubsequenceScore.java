import java.util.*;

public class MaximumSubsequenceScore {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int[][] nums = new int[nums1.length][2];
        for (int i = 0; i < nums1.length; i++) {
            nums[i][0] = nums1[i];
            nums[i][1] = nums2[i];
        }
        Arrays.sort(nums, (a, b) -> b[1] - a[1]);
        Queue<Integer> que = new PriorityQueue<>((a, b) -> nums[a][0] - nums[b][0]);
        long sum = 0, max = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i][0];
            que.offer(i);
            if (que.size() > k) {
                int ind = que.poll();
                sum -= nums[ind][0];
            }
            if (que.size() == k) {
                max = Math.max(max, sum * nums[i][1]);
            }
        }
        return max;
    }
}
