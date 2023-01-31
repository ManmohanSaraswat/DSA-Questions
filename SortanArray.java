import java.util.PriorityQueue;
import java.util.Queue;

public class SortanArray {
    public int[] sortArray(int[] nums) {
        Queue<Integer> que = new PriorityQueue<>();
        for(int i: nums) que.offer(i);
        for(int i = 0; i < nums.length; i++) nums[i] = que.poll();
        return nums;
    }
}
