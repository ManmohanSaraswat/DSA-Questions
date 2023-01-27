import java.util.*;

public class CheapestFlightsWithinKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> lst = new ArrayList<>();
        for (int i = 0; i < n; i++)
            lst.add(new ArrayList<>());
        for (int[] flight : flights) {
            lst.get(flight[0]).add(new int[] { flight[1], flight[2] });
        }
        Queue<int[]> que = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        int[] moves = new int[n];
        que.offer(new int[] { src, 0, 0 });
        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int source = cur[0], stopsCompleted = cur[1], totalPrice = cur[2];
            moves[source]++;
            if (source == dst)
                return totalPrice;
            if (stopsCompleted <= k && moves[source] <= k + 1)
                for (int[] dests : lst.get(source)) {
                    que.offer(new int[] { dests[0], stopsCompleted + 1, totalPrice + dests[1] });
                }
        }
        return -1;
    }
}
