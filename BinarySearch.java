import java.util.Arrays;

public class BinarySearch {
    public int search(int[] nums, int target) {
        int ind = Arrays.binarySearch(nums, target);
        return ind < 0 ? -1 : ind;
    }
}
