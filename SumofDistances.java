import java.util.*;

public class SumofDistances {
    public long[] distance(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = map.getOrDefault(nums[i], new ArrayList<>());
            list.add(i);
            map.put(nums[i], list);
        }
        long[] res = new long[nums.length];
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> list = entry.getValue();
            int n = list.size();
            long[] prefix = new long[n + 1];
            for (int i = 0; i < n; i++) {
                prefix[i + 1] = prefix[i] + list.get(i);
            }
            for (int i = 0; i < n; i++) {
                res[list.get(i)] = list.get(i) * 1L * (i + 2) - 2 * prefix[i + 1] + prefix[n]
                        - list.get(i) * 1L * (n - i);
            }
        }
        return res;
    }
}
