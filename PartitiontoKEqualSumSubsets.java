import java.util.*;

public class PartitiontoKEqualSumSubsets {
    Map<String, Boolean> map;

    public boolean canPartitionKSubsets(int[] A, int k) {
        map = new HashMap<>();
        if (k > A.length)
            return false;
        int sum = 0;
        for (int num : A)
            sum += num;
        if (sum % k != 0)
            return false;
        Arrays.sort(A);
        return dfs(A, 0, A.length - 1, 0, sum / k, k);
    }

    public boolean dfs(int[] A, int sum, int st, int visited, int target, int round) {
        if (round == 0) {
            map.put(sum + "" + st + "" + visited + "" + round, true);
            return true;
        }
        Boolean ans = map.getOrDefault(sum + "" + st + "" + visited + "" + round, null);
        if (ans != null)
            return ans;
        if (sum == target && dfs(A, 0, A.length - 1, visited, target, round - 1)) {
            map.put(sum + "" + st + "" + visited + "" + round, true);
            return true;
        }
        for (int i = st; i >= 0; --i) {
            if ((visited & (1 << i)) == 0 && sum + A[i] <= target) {
                visited = visited ^ (1 << i);
                if (dfs(A, sum + A[i], i - 1, visited, target, round)) {
                    map.put(sum + "" + st + "" + visited + "" + round, true);
                    return true;
                }
                visited = visited ^ (1 << i);
            }
        }
        map.put(sum + "" + st + "" + visited + "" + round, false);
        return false;
    }
}
