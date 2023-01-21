import java.util.*;

public class NondecreasingSubsequences {
    public List<List<Integer>> findSubsequences(int[] nums) {
        int bits = (1 << nums.length), n = nums.length;
        Set<List<Integer>> set = new HashSet<>();
        for (int bit = 0; bit < bits; bit++) {
            LinkedList<Integer> temp = new LinkedList<>();
            for (int j = 0; j < n; j++) {
                if (((1 << j) & bit) != 0) {
                    if (temp.size() == 0 || nums[j] >= temp.peekLast())
                        temp.add(nums[j]);
                }
            }
            if (temp.size() >= 2) {
                set.add(temp);
            }
        }
        return new ArrayList<>(set);
    }
}
