import java.util.Arrays;

public class ThreeSumClosest {
    private static int findClosestNumber(int[] arr, int start, int end, int target) {
        if(target <= arr[start]) return arr[start];
        if(target >= arr[end]) return arr[end];
        int mid = (start + end)/2;
        int a = findClosestNumber(arr, start, mid, target);
        int b = findClosestNumber(arr, mid+1, end, target);
        if(Math.abs(target-a) < Math.abs(target-b)) return a;
        return b;
    }
    public int threeSumClosest(int[] arr, int target) {
        Arrays.sort(arr);
        int n = arr.length, ans = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n-1; j++){
                int find = target - (arr[i] + arr[j]);
                int x = findClosestNumber(arr, j+1, n-1, find);
                if(Math.abs(target-ans) > Math.abs(target-(arr[i] + arr[j] + x)))
                    ans = arr[i] + arr[j] + x;
            }
        }
        return ans;
    }
}
