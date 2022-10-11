public class IncreasingTripletSubsequence {
    public boolean increasingTripletApproach1(int[] nums) {
        int n = nums.length;
        int[] greater = new int[n];
        int smaller[] = new int[n];
        greater[n - 1] = nums[n - 1];
        smaller[0] = nums[0];
        for (int i = n - 2; i >= 0; i--) {
            greater[i] = Math.max(greater[i + 1], nums[i]);
        }
        for (int i = 1; i < n; i++) {
            smaller[i] = Math.min(smaller[i - 1], nums[i]);
        }
        for (int i = 1; i < n - 1; i++)
            if (nums[i] != smaller[i] && nums[i] != greater[i])
                return true;

        return false;
    }

    public boolean increasingTripletApproach2(int[] nums) {
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= min1)
                min1 = nums[i];
            if (nums[i] > min1 && nums[i] < min2)
                min2 = nums[i];
            else if (nums[i] > min2)
                return true;
        }
        return false;
    }
}