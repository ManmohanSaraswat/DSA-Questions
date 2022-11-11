public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] arr) {
        int i = 0, j = 0;
        while (j < arr.length) {
            if (arr[i] != arr[j]) {
                i++;
                arr[i] = arr[j];
            }
            j++;
        }
        return i + 1;
    }
}