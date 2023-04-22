public class OptimalPartitionofString {
    public int partitionString(String s) {
        char[] arr = s.toCharArray();
        int count = 0, bit = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((bit & (1 << (arr[i] - 'a'))) != 0) {
                bit = 0;
                count++;
            }
            bit = bit ^ (1 << (arr[i] - 'a'));
        }
        return count + 1;
    }
}
