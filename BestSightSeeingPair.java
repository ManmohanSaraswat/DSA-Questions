import java.util.PriorityQueue;

public class BestSightSeeingPair {
    public int maxScoreSightseeingPair(int[] values) {
        PriorityQueue<Integer> pQueue = new PriorityQueue<>((a, b) -> b - a);
        pQueue.add(values[0]);
        int max = 0;
        for(int i = 1; i < values.length; i++){
            max = Math.max(max, pQueue.peek() + (values[i] - i));
            pQueue.add(values[i] + i);
        }
        return max;
    }
    public int maxScoreSightseeingPairOptimized(int[] values) {
        int max = 0, prevMax = values[0];
        for(int i = 1; i < values.length; i++){
            max = Math.max(max, prevMax + (values[i] - i));
            prevMax = Math.max(prevMax, values[i] + i);
        }
        return max;
    }
}
