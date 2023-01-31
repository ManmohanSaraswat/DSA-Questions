import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinimumOperationstoHalveArraySum {
    public int halveArray(int[] nums) {
        double sum = 0, reach = 0;
        int count = 0;
        Queue<Double> que = new PriorityQueue<>(Collections.reverseOrder());
        for(int i: nums){
            sum += i;
            que.offer((double)i);
        }
        while(reach < sum / 2){
            double x = que.poll();
            reach += x / 2;
            que.offer(x / 2);
            count ++;
        }
        return count;
    }
}
