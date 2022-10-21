import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate2 {

    static class Pair implements Comparable<Pair> {
        int a, b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public int compareTo(Pair p) {
            return this.a != p.a ? this.a - p.a : this.b - p.b;
        }
    }

    public boolean containsNearbyDuplicateNotEfficient(int[] nums, int k) {
        Pair[] pairs = new Pair[nums.length];
        for (int i = 0; i < nums.length; i++) {
            pairs[i] = new Pair(nums[i], i);
        }
        Arrays.sort(pairs);
        for (int i = 1; i < nums.length; i++) {
            if (pairs[i].a == pairs[i - 1].a && Math.abs(pairs[i].b - pairs[i - 1].b) <= k)
                return true;
        }
        return false;
    }

    public boolean containsNearbyDuplicateUsingSlidingWindow(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k)
                set.remove(nums[i - k - 1]);
            if (!set.add(nums[i]))
                return true;
        }
        return false;
    }
}