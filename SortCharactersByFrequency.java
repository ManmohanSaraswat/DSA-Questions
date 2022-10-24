import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray())
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        PriorityQueue<Map.Entry<Character, Integer>> pQueue = new PriorityQueue<>(
            (a, b) -> a.getValue() - b.getValue()
        );
        for(Map.Entry<Character, Integer> entry : map.entrySet())
            pQueue.add(entry);
        StringBuilder res = new StringBuilder();
        while(!pQueue.isEmpty()){
            Map.Entry<Character, Integer> entry = pQueue.poll();
            char ch = entry.getKey();
            int freq = entry.getValue();
            while(freq -- > 0)
                res.append(ch);
        }
        return res.toString();
    }
}
