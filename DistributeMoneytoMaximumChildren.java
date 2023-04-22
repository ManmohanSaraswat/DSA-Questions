import java.util.Arrays;

public class DistributeMoneytoMaximumChildren {
    public int distMoney(int money, int children) {
        if (money < children)
            return -1;
        if (money - children == 3)
            return 0;
        int n = money - children, count = 0, i = 0;
        int[] arr = new int[children];
        Arrays.fill(arr, 1);
        for (i = 0; i < arr.length; i++) {
            if (n - 7 >= 0) {
                count++;
                n = n - 7;
            } else
                break;
        }
        if ((n == 3 && i >= arr.length - 1) || (n > 0 && i == arr.length))
            return count - 1;

        return count;
    }
}
