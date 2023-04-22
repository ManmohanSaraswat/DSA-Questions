import java.util.*;

public class FindtheSubstringWithMaximumCost {
    public int maximumCostSubstring(String s, String chars, int[] vals) {
        Map<Character, Integer> map = new HashMap<>();
        char str[] = s.toCharArray();
        char[] charss = chars.toCharArray();
        for (int i = 0; i < charss.length; i++) {
            map.put(charss[i], vals[i]);
        }
        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (!map.containsKey(ch)) {
                map.put(ch, (int) (ch - 'a') + 1);
            }
        }
        int cur = 0;
        int maxSoFar = 0;
        for (int i = 0; i < str.length; i++) {
            cur += map.get(str[i]);
            if (cur <= 0) {
                cur = 0;
            }
            maxSoFar = Math.max(maxSoFar, cur);
        }
        return Math.max(maxSoFar, 0);
    }
}
