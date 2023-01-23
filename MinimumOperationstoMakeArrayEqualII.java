public class MinimumOperationstoMakeArrayEqualII {
    public long minOperations(int[] nums1, int[] nums2, int k) {
        long pos = 0, neg = 0;
        for (int i = 0; i < nums1.length; i++) {
            long diff = nums1[i] - nums2[i];
            if (diff < 0)
                neg += diff;
            else
                pos += diff;
            diff = Math.abs(diff);
            if (k != 0 && diff % k != 0)
                return -1;
        }
        if (pos == Math.abs(neg)) {
            if (k == 0) {
                if (pos == 0)
                    return 0;
                return -1;
            }
            return pos / k;
        }
        return -1;
    }
}
