import java.util.PriorityQueue;
import java.util.Queue;

public class KClosestPointstoOrigin {
    public int[][] kClosest(int[][] points, int k) {
        Queue<Integer> que = new PriorityQueue<>((a, b) -> {
            double x = Math.sqrt(Math.pow(points[a][0], 2) + Math.pow(points[a][1], 2));
            double y = Math.sqrt(Math.pow(points[b][0], 2) + Math.pow(points[b][1], 2));
            return Double.compare(x, y);
        });
        for(int i = 0; i < points.length; i++){
            que.offer(i);
        }
        int[][] res = new int[k][];
        for(int i = 0; i < k; i++){
            res[i] = points[que.poll()];
        }
        return res;
    }
}
