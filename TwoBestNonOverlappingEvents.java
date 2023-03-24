import java.util.Arrays;

public class TwoBestNonOverlappingEvents {
    private boolean overlapping(int[][] events, int i, int j) {
        return events[i][1] >= events[j][0];
    }

    private int binarySearch(int[][] events, int start, int target) {
        int end = events.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (overlapping(events, target, mid))
                start = mid + 1;
            else
                end = mid - 1;
        }
        return start;
    }

    private int solve(int[][] events) {
        int maxVals[] = new int[events.length], max = Integer.MIN_VALUE;
        for (int i = events.length - 1; i >= 0; i--) {
            max = Math.max(max, events[i][2]);
            maxVals[i] = max;
        }
        int res = 0;
        for (int i = 0; i < events.length; i++) {
            int ind = binarySearch(events, i + 1, i);
            if (ind == events.length)
                res = Math.max(res, events[i][2]);
            else
                res = Math.max(res, events[i][2] + maxVals[ind]);
        }
        return res;
    }

    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
        return solve(events);
    }
}
