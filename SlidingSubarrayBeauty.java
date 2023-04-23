public class SlidingSubarrayBeauty {
    public int find(int[] arr, int x) {
        int cnt = 0;
        for (int i = 50; i >= 1; i--) {
            cnt += arr[i];
            if (cnt >= x)
                return -i;
        }
        return 0;
    }

    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int[] arr = new int[51];
        for (int i = 0; i < k - 1; i++) {
            if (nums[i] < 0)
                arr[-nums[i]]++;
        }
        int res[] = new int[nums.length - k + 1], cnt = 0;
        for (int i = k - 1; i < nums.length; i++) {
            if (nums[i] < 0)
                arr[-nums[i]]++;
            res[cnt] = find(arr, x);
            if (nums[i - k + 1] < 0) {
                arr[-nums[i - k + 1]]--;
            }
            cnt++;
        }
        return res;
    }
}
