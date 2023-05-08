import java.util.Arrays;

public class MinimizetheMaximumDifferenceofPairs {
    private boolean canMake(int[] arr, int target, int p) {
        int i = 0, n = arr.length, cnt = 0;
        boolean cur = false;
        while (i < n) {
            if (!cur && arr[i] <= target) {
                cnt++;
                cur = true;
            } else {
                cur = false;
            }
            i++;
        }
        return cnt >= p;
    }

    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int[] arr = new int[nums.length - 1];
        for (int i = 0; i < nums.length - 1; i++) {
            arr[i] = nums[i + 1] - nums[i];
        }
        int start = 0, end = Integer.MAX_VALUE;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (canMake(arr, mid, p))
                end = mid;
            else
                start = mid + 1;
        }
        return start;
    }
}
