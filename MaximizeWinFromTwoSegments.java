public class MaximizeWinFromTwoSegments {
    private int upperBound(int[] arr, int target) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] <= target)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return start - 1;
    }

    public int maximizeWin(int[] arr, int k) {
        int[] maxReach = new int[arr.length], res = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            maxReach[i] = upperBound(arr, arr[i] + k);
        }
        int max = Integer.MIN_VALUE;
        for (int i = arr.length - 1; i >= 0; i--) {
            max = Math.max(max, maxReach[i] - i + 1);
            res[i] = max;
        }
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, maxReach[i] - i + 1 + res[maxReach[i] + 1]);
        }
        return max;
    }
}
