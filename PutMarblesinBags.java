import java.util.PriorityQueue;
import java.util.Queue;

public class PutMarblesinBags {
    public long putMarbles(int[] weights, int k) {
        int n = weights.length;
        if(k == n) return 0;
        Queue<int[]> que = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        Queue<int[]> que1 = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for(int i = 1; i < n; i++){
            que.offer(new int[]{weights[i] + weights[i - 1], i});
            que1.offer(new int[]{weights[i] + weights[i - 1], i});
        }
        long min = weights[0] + weights[n - 1];
        long max = min;
        for(int i = 0; i < k - 1; i++){
            int index = que.poll()[1];
            min += weights[index] + weights[index - 1];
            index = que1.poll()[1];
            max += weights[index] + weights[index - 1];
        }
        return max - min;
    }
}
