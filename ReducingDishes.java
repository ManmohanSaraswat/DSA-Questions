import java.util.Arrays;

public class ReducingDishes {
    public int maxSatisfaction(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int count = 1, temp = 0;
            for (int j = i; j < n; j++) {
                temp += count * arr[j];
                count++;
            }
            sum = Math.max(temp, sum);
        }
        return sum;
    }

    public int maxSatisfactionEfficient(int[] arr) {
        Arrays.sort(arr);
        int sum = 0, cur = 0, temp = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            cur += arr[i];
            temp += cur;
            sum = Math.max(sum, temp);
        }
        return sum;
    }
}
