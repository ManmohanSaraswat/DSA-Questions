public class LongestBinarySubsequenceLessThanorEqualtoK {
    public int longestSubsequence(String s, int k) {
        int zeros = 0, prevOnes = 0;
        char[] arr = s.toCharArray();
        int[] suffix = new int[arr.length + 1];
        for (int i = arr.length - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1];
            if (arr[i] == '0') {
                suffix[i]++;
                zeros++;
            }
        }
        long sum = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == '1') {
                sum = sum + (long) Math.pow(2, prevOnes + suffix[i]);
                if (sum > k)
                    return zeros + prevOnes;
                prevOnes++;
            }
        }
        return zeros + prevOnes;
    }

    public int longestSubsequenceOptimized(String s, int k) {
        int zeros = 0, prevOnes = 0;
        long sum = 0;
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == '0')
                zeros++;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == '1') {
                sum += (1L << (arr.length - i - 1));
                if (sum > k)
                    return zeros + prevOnes;
                prevOnes++;
            }
        }
        return zeros + prevOnes;
    }
}
