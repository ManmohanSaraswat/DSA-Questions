public class ClosestNumber {
    public static void main(String[] args) {
        int arr[] = new int[]{1, 2, 3, 4, 5,6 ,7 ,8, 9, 20};
        System.out.println(findClosestNumber(arr, 0, arr.length-1, 6));
    }

    private static int findClosestNumber(int[] arr, int start, int end, int target) {
        if(target <= arr[start]) return arr[start];
        if(target >= arr[end]) return arr[end];
        int mid = (start + end)/2;
        int a = findClosestNumber(arr, start, mid, target);
        int b = findClosestNumber(arr, mid+1, end, target);
        if(Math.abs(target-a) < Math.abs(target-b)) return a;
        return b;
    }
}
