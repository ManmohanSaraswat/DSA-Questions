import java.util.*;

public class MostPopularVideoCreator {
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        Map<String, Long> map = new HashMap<>();
        Map<String, List<Integer>> hmap = new HashMap<>();
        for (int i = 0; i < creators.length; i++) {
            map.put(creators[i], map.getOrDefault(creators[i], 0L) + views[i]);
            if (hmap.containsKey(creators[i])) {
                List<Integer> ll = hmap.get(creators[i]);
                ll.add(i);
                hmap.put(creators[i], ll);
            } else {
                List<Integer> ll = new ArrayList<>();
                ll.add(i);
                hmap.put(creators[i], ll);
            }
        }
        long max = 0;
        for (Map.Entry<String, Long> entry : map.entrySet()) {
            max = Math.max(max, entry.getValue());
        }
        List<List<String>> ans = new ArrayList<>();
        for (Map.Entry<String, Long> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                List<Integer> res = hmap.get(entry.getKey());
                Collections.sort(res, (a, b) -> views[a] == views[b] ? ids[a].compareTo(ids[b]) : views[b] - views[a]);
                List<String> z = new ArrayList<>();
                z.add(entry.getKey());
                z.add(ids[res.get(0)]);
                ans.add(z);
            }
        }
        return ans;
    }
}
