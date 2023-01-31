import java.util.PriorityQueue;
import java.util.Queue;

public class SmallestNumberinInfiniteSet {
    Queue<Integer> que;
    int[] nums;
    public SmallestNumberinInfiniteSet() {
        que = new PriorityQueue<>();
        for(int i = 1; i <= 1000; i++){
            que.offer(i);
        }
        nums = new int[1001];
    }
    
    public int popSmallest() {
        int res = -1;
        while(true){
            res = que.poll();
            if(nums[res] == 0) break;
        }
        nums[res] = -1;
        return res;
    }
    
    public void addBack(int num) {
        que.offer(num);
        nums[num] = 0;
    }
}
