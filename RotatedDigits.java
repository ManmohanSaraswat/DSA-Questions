import java.util.stream.IntStream;

public class RotatedDigits {
    int[] rotation;

    private boolean isValid(int n) {
        int sum = 0, temp = n, count = 0;
        while (n > 0) {
            int x = n % 10;
            if (x == 3 || x == 4 || x == 7)
                return false;
            sum = rotation[x] * (int) Math.pow(10, count) + sum;
            count++;
            n /= 10;
        }
        return temp != sum;
    }

    public int rotatedDigits(int n) {
        rotation = new int[] { 0, 1, 5, 3, 4, 2, 9, 7, 8, 6 };
        return (int) IntStream.rangeClosed(1, n).filter(x -> isValid(x)).count();
    }
}
