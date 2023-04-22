import java.util.Arrays;

public class MaximizeGreatnessofanArray {
    public int maximizeGreatness(int[] nums) {
        Arrays.sort(nums);
        int i = 0, j = 0, count = 0;
        while (i < nums.length && j < nums.length) {
            if (nums[i] == nums[j])
                j++;
            else {
                count++;
                i++;
                j++;
            }
        }
        return count;
    }
}
