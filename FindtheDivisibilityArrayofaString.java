public class FindtheDivisibilityArrayofaString {
    public int[] divisibilityArray(String word, int m) {
        char[] arr = word.toCharArray();
        int res[] = new int[arr.length];
        long carry = 0;
        for (int i = 0; i < arr.length; i++) {
            carry = carry * 10 + (arr[i] - '0');
            if (carry % m == 0)
                res[i] = 1;
            else
                res[i] = 0;
            carry = carry % m;
        }
        return res;
    }
}
