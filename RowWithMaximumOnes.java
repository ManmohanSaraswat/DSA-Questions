import java.util.Arrays;

public class RowWithMaximumOnes {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int[][] arr = new int[mat.length][2];
        for (int i = 0; i < mat.length; i++) {
            int count = 0;
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1)
                    count++;
            }
            arr[i][0] = i;
            arr[i][1] = count;
        }
        Arrays.sort(arr, (a, b) -> a[1] == b[1] ? a[0] - b[0] : b[1] - a[1]);
        return new int[] { arr[0][0], arr[0][1] };
    }
}
