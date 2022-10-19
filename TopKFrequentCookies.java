import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentCookies {

    static class Pair implements Comparable<Pair> {
        String st;
        int c;

        public Pair(String st, int c) {
            this.st = st;
            this.c = c;
        }

        public int compareTo(Pair p) {
            return p.c != this.c ? p.c - this.c : this.st.compareTo(p.st);
        }
    }

    public List<String> topKFrequentApproach1(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String str : words) {
            int i = map.getOrDefault(str, 0);
            map.put(str, i + 1);
        }
        List<Pair> pairs = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pairs.add(new Pair(entry.getKey(), entry.getValue()));
        }
        Collections.sort(pairs);
        List<String> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(pairs.get(i).st);
        }
        return res;
    }

    public List<String>  topKFrequentApproach2(String[] words, int k){
        Map<String, Integer> map = new HashMap<>();
        for (String str : words) {
            int i = map.getOrDefault(str, 0);
            map.put(str, i + 1);
        }
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
        (a, b) -> a.getValue() != b.getValue() ? b.getValue() - a.getValue() : a.getKey().compareTo(b.getKey()));
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            pq.add(entry);
        }
        List<String> res = new ArrayList<>();
        for(int i = 0; i < k; i++){
            res.add(pq.remove().getKey());
        }
        return res;
    }
}