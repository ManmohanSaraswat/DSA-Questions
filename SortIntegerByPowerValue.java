import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortIntegerByPowerValue {
    static Map<Integer, Integer> map;
    private class Pair implements Comparable<Pair>{
        int a, b;
        public int compareTo(Pair p){
            if(this.a != p.a) return this.a - p.a;
            return this.b - p.b;
        }
        Pair(int a, int b){
            this.a = a;
            this.b = b;
        }
    }
    public int findPower(int x){
        if(x == 1) return 0;
        if(map.containsKey(x)) return map.get(x);
        if(x % 2 == 0) return 1 + findPower(x / 2);
        int ans = 1 + findPower(x * 3 + 1);
        map.put(x, ans);
        return ans;
    }
    public int getKth(int lo, int hi, int k) {
        map = new HashMap<>();
        List<Pair> res = new ArrayList<>();
        for(; lo <= hi; lo++){
            res.add(new Pair(findPower(lo)-1, lo));
        }  
        Collections.sort(res);
        return res.get(k-1).b;
    }
}