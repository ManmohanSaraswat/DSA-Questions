import java.util.*;

public class UniqueNumberofOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.stream(arr).forEach(val -> map.put(val, map.getOrDefault(val, 0) + 1));
        Set<Integer> set = new HashSet<>();
        return !map.entrySet().stream().anyMatch(entry -> !set.add(entry.getValue()));
    }
}
