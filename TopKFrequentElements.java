import java.util.*;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i: nums)
            map.put(i, map.getOrDefault(i, 0) + 1);
        Queue<int[]> que = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            que.offer(new int[]{entry.getValue(), entry.getKey()});
        }
        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = que.poll()[1];
        }
        return res;
    }
}
