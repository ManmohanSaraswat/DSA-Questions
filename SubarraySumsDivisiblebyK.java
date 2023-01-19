import java.util.HashMap;
import java.util.Map;

public class SubarraySumsDivisiblebyK {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0, 1);
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            int rem = sum % k;
            if(rem < 0) rem += k;
            if(map.containsKey(rem)) res += map.get(rem);
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }       
        return res;
    }
}
