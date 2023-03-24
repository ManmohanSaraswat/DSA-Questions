import java.util.Arrays;

public class MaximumTotalImportanceofRoads {
    public long maximumImportance(int n, int[][] roads) {
        int res[][] = new int[n][2];
        for (int[] road : roads) {
            res[road[0]][0] = road[0];
            res[road[1]][0] = road[1];
            res[road[0]][1]++;
            res[road[1]][1]++;
        }
        int[] arr = new int[n];
        Arrays.sort(res, (a, b) -> a[1] - b[1]);
        for (int i = 0; i < n; i++) {
            arr[res[i][0]] = i + 1;
        }
        long res1 = 0;
        for (int road[] : roads) {
            res1 += arr[road[0]] + arr[road[1]];
        }
        return res1;
    }
}