public class LexicographicallySmallestPalindrome {
    public String makeSmallestPalindrome(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        for (int i = 0; i < n / 2; i++) {
            if (arr[i] == arr[n - i - 1]) {
                continue;
            } else {
                if (arr[i] < arr[n - i - 1]) {
                    arr[n - i - 1] = arr[i];
                } else {
                    arr[i] = arr[n - i - 1];
                }
            }
        }
        return new String(arr);
    }
}
