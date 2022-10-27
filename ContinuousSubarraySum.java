import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
             sum += nums[i];
            if(map.containsKey(sum % k)){
                int index = map.get(sum % k);
                if(i - index > 1) return true;
            }else
                map.put(sum % k, i);
        }
        return false;
    }
}
