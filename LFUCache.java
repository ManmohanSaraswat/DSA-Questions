import java.util.*;
public class LFUCache {
    int n;
    Map<Integer, Integer> map;
    Map<Integer, List<Integer>> que;
    int[] frequency;
    public LFUCache(int capacity) {
        n = capacity;
        map = new HashMap<>();
        frequency = new int[200000];
        que = new TreeMap<>();
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            if(frequency[key] > 0){
                List<Integer> ll = que.get(frequency[key]);
                ll.remove(new Integer(key));
                que.put(frequency[key], ll);
            }
            frequency[key] ++;
            List<Integer> ll = que.getOrDefault(frequency[key], new ArrayList<>());
            ll.add(key);
            que.put(frequency[key], ll);
            return map.get(key);
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(n == 0) return;
        if(map.containsKey(key)){
            if(frequency[key] > 0){
                List<Integer> ll = que.get(frequency[key]);
                ll.remove(new Integer(key));
                que.put(frequency[key], ll);
            }
        }else if(map.size() == n){
            List<Integer> ll = new ArrayList<>();
            int xVal = 0;
            for(Map.Entry<Integer, List<Integer>> mm: que.entrySet()){
                if(mm.getValue().size() == 0) continue;
                ll = mm.getValue();
                xVal = mm.getKey();
                break;
            }
            int xKey = ll.get(0);
            
            ll.remove(0);
            if(ll.size() == 0) que.remove(frequency[xKey]);
            else
            que.put(xVal, ll);
            frequency[xKey] = 0;
            map.remove(xKey);
        }
        frequency[key] ++;
        List<Integer> lst = que.getOrDefault(frequency[key], new ArrayList<>());
        lst.add(key);
        que.put(frequency[key], lst);
        map.put(key, value);
    }
}