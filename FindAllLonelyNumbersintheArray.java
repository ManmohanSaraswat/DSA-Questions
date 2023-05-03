import java.util.*;

public class FindAllLonelyNumbersintheArray {
    public List<Integer> findLonely(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                if (!map.containsKey(entry.getKey() - 1) && !map.containsKey(entry.getKey() + 1))
                    res.add(entry.getKey());
            }
        }
        return res;
    }
}
