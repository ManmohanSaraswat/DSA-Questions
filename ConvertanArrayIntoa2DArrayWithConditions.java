import java.util.*;

public class ConvertanArrayIntoa2DArrayWithConditions {
    public List<List<Integer>> findMatrix(int[] nums) {
        Arrays.sort(nums);
        int count = 0, prev = -1;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (prev == nums[i])
                count++;
            else
                count = 0;
            if (res.size() == count) {
                res.add(new ArrayList<>());
            }
            res.get(count).add(nums[i]);
            prev = nums[i];
        }
        return res;
    }
}
