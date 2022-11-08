import java.util.Arrays;

public class OrderlyQueue {
    public String orderlyQueue(String s, int k) {
        char[] arr = s.toCharArray();
        if (k > 1) {
            Arrays.sort(arr);
            return String.valueOf(arr);
        }
        char min = (char) s.chars().min().getAsInt();
        String res = s;
        for (int i = 0; i < arr.length; i++) {
            if (min == arr[i]) {
                String temp = s.substring(i) + s.substring(0, i);
                res = res.compareTo(temp) <= 0 ? res : temp;
            }
        }
        return res;
    }
}
