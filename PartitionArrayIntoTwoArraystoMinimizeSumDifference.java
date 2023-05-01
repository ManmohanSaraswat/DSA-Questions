import java.util.*;

public class PartitionArrayIntoTwoArraystoMinimizeSumDifference {
    private int binarySearch(List<Integer> lst, int target) {
        int start = 0, end = lst.size();
        while (start < end) {
            int mid = (start + end) / 2;
            if (lst.get(mid) == target)
                return target;
            else if (lst.get(mid) < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        if (start < 0)
            return lst.get(0);
        else if (start == lst.size())
            return lst.get(start - 1);
        return lst.get(start);
    }

    private void solve(int[] nums, int n, int N, int sum, Map<Integer, List<Integer>> map, int tot) {
        if (n == N) {
            List<Integer> lst = map.getOrDefault(tot, new ArrayList<>());
            lst.add(sum);
            map.put(tot, lst);
            return;
        }
        solve(nums, n + 1, N, sum + nums[n], map, tot + 1);
        solve(nums, n + 1, N, sum, map, tot);
    }

    public int minimumDifference(int[] nums) {
        int total = 0;
        for (int num : nums)
            total += num;
        Map<Integer, List<Integer>> m1 = new HashMap<>();
        Map<Integer, List<Integer>> m2 = new HashMap<>();
        solve(nums, 0, nums.length / 2, 0, m1, 0);
        solve(nums, nums.length / 2, nums.length, 0, m2, 0);
        int res = Integer.MAX_VALUE;
        for (Map.Entry<Integer, List<Integer>> entry : m1.entrySet()) {
            int n = entry.getKey();
            List<Integer> sums = entry.getValue();
            List<Integer> sums1 = m2.get(nums.length / 2 - n);
            Collections.sort(sums1, (a, b) -> Integer.compare(a, b));
            for (int s1 : sums) {
                int s2 = binarySearch(sums1, total / 2 - s1);
                // for(int s2: sums1){
                res = Math.min(res, Math.abs(s1 + s2 - (total - (s1 + s2))));
                // }
            }
        }
        return res;
    }
}
