import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementinaStream {
    Queue<Integer> que;
    int capacity;
    public KthLargestElementinaStream(int k, int[] nums) {
        capacity = k;
        que = new PriorityQueue<>();
        for(int i: nums){
            que.offer(i);
        }
        while(que.size() > capacity){
            que.poll();
        }
    }
    
    public int add(int val) {
        que.offer(val);
        while(que.size() > capacity){
            que.poll();
        }
        return que.peek();
    }
}
