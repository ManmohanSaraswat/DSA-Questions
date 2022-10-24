import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortArrayByIncreasingFrequency {
    
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums)
            map.put(i, map.getOrDefault(i, 0) + 1);
        PriorityQueue<Map.Entry<Integer, Integer>> pQueue = new PriorityQueue<>(
            (a, b) -> a.getValue() != b.getValue() ? a.getValue() - b.getValue() : b.getKey() - a.getKey()
        );
        for(Map.Entry<Integer, Integer> entry : map.entrySet())
            pQueue.add(entry);
        int[] res = new int[nums.length];
        for(int i = 0; i < nums.length; i++)
            res[i] = pQueue.poll().getKey();
        return res;
    }
}