import java.util.Arrays;

public class FormSmallestNumberFromTwoDigitArrays {
    public int minNumber(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j])
                    return nums1[i];
            }
        }
        int l = nums1[0], r = nums2[0];
        if (l < r)
            return l * 10 + r;
        return r * 10 + l;
    }
}
