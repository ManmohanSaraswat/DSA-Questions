import java.util.*;

public class SuminaMatrix {
    public int matrixSum(int[][] nums) {
        Queue<Integer> que[] = new PriorityQueue[nums.length];
        for (int i = 0; i < nums.length; i++) {
            que[i] = new PriorityQueue<>(Collections.reverseOrder());
            for (int j = 0; j < nums[i].length; j++) {
                que[i].add(nums[i][j]);
            }
        }
        int cnt = 0;
        for (int j = 0; j < nums[0].length; j++) {
            int max = 0;
            for (int i = 0; i < nums.length; i++) {
                max = Math.max(max, que[i].poll());
            }
            cnt += max;
        }
        return cnt;
    }
}
