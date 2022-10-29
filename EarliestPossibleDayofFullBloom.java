import java.util.Arrays;

public class EarliestPossibleDayofFullBloom {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int n = plantTime.length;
        int[][] times = new int[n][2];
        for(int i = 0; i < n; i++){
            times[i][0] = growTime[i];
            times[i][1] = plantTime[i];
        }
        Arrays.sort(times, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        int total = 0;
        for(int i = 0; i < n; i++){
            total = Math.max(total, times[i][0]) + times[i][1];
        }
        return total;
    }
}
