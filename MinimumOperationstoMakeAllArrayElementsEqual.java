import java.util.*;

public class MinimumOperationstoMakeAllArrayElementsEqual {
    public List<Long> minOperations(int[] nums, int[] queries) {
        Arrays.sort(nums);
        List<Long> res = new ArrayList<>();
        long[] prefixSum = new long[nums.length + 1];
        for (int i = 1; i <= nums.length; i++)
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        for (int i = 0; i < queries.length; i++) {
            int x = Arrays.binarySearch(nums, queries[i]);
            if (x < 0)
                x = -x - 1;
            res.add(1L * queries[i] * x - prefixSum[x] + 1L * (prefixSum[nums.length] - prefixSum[x])
                    - queries[i] * 1L * (nums.length - x));
        }
        return res;
    }
}
