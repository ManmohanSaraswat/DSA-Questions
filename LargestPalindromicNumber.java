import java.util.*;

public class LargestPalindromicNumber {
    public String largestPalindromic(String num) {
        int[] arr = new int[10];
        char[] brr = num.toCharArray();
        for (int i = 0; i < brr.length; i++) {
            arr[brr[i] - '0']++;
        }
        List<int[]> res = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        while (true) {
            int n = res.size();
            for (int i = 9; i >= 0; i--) {
                if (arr[i] > 1) {
                    if (i == 0 && n == 0)
                        break;
                    res.add(new int[] { i, (arr[i] / 2) * 2 });
                    arr[i] = arr[i] - (arr[i] / 2) * 2;
                }
            }
            if (res.size() == n)
                break;
        }
        for (int[] val : res) {
            int toAdd = val[1] / 2;
            for (int i = 0; i < toAdd; i++) {
                str.append(val[0]);
            }
            val[1] /= 2;
        }
        for (int i = 9; i >= 0; i--) {
            if (arr[i] >= 1) {
                StringBuilder newS = new StringBuilder(str);
                String rev = str.reverse().toString();
                newS.append(i);
                newS.append(rev);
                return newS.toString();
            }
        }
        return str.toString() + str.reverse().toString();
    }
}
