import java.util.*;

public class SeparatetheDigitsinanArray {
    public int[] separateDigits(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            List<Integer> lst = new ArrayList<>();
            while(n > 0){
                lst.add(0, n % 10);
                n /= 10;
            }
            res.addAll(lst);
        }
        int[] a = new int[res.size()];
        for(int i = 0; i < a.length; i++) a[i] = res.get(i);
        return a;
    }
}
