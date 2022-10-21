import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman {

    Map<Integer, String> map;

    public String solve(int value, int tens) {
        if (value == 0)
            return "";
        if (map.containsKey(value * tens))
            return map.get(value * tens);
        if (value == 4 || value == 9)
            return map.get(tens) + map.get((value + 1) * tens);
        return solve(value - 1, tens) + map.get(tens);
    }

    public String intToRoman(int num) {
        map = new HashMap<>();
        map.put(1, "I");
        map.put(5, "V");
        map.put(10, "X");
        map.put(50, "L");
        map.put(100, "C");
        map.put(500, "D");
        map.put(1000, "M");
        int count = 0;
        String res = "";
        while (num > 0) {
            res = solve(num % 10, (int) Math.pow(10, count)) + res;
            num = num / 10;
            count++;
        }
        return res;
    }
}