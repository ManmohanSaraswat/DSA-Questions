import java.util.*;
import java.util.stream.Collectors;

public class FindtheDifferenceofTwoArrays {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> s1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> s2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        Set<Integer> a1 = Arrays.stream(nums1).filter(n -> !s2.contains(n)).boxed().collect(Collectors.toSet());
        Set<Integer> a2 = Arrays.stream(nums2).filter(n -> !s1.contains(n)).boxed().collect(Collectors.toSet());
        return Arrays.asList(new ArrayList<>(a1), new ArrayList<>(a2));
    }
}
