public class MaximizeWinFromTwoSegments {
    private int upperBound(int[] arr, int element){
        int start = 0, end = arr.length;
        while(start < end){
            int mid = (start + end) / 2;
            if(arr[mid] <= element){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return start;
    }
    private int solve(int[] arr, int k){
        int res = 0;
        for(int i = 0; i < arr.length; i++){
            int bound = upperBound(arr, arr[i] + k);
            res = Math.max(res, bound - i);
        }
        return res;
    }
    public int maximizeWin(int[] prizePositions, int k) {
        return solve(prizePositions, k);
    }
}
