import java.util.*;

public class ScrambleString {
    Map<String, Boolean> map;

    private boolean solve(String s1, String s2) {
        if (s1.equals(s2))
            return true;
        if (s1.length() == 1)
            return false;
        String key = s1 + s2;
        int[] a = new int[26], b = new int[26], c = new int[26];

        int len = s1.length();
        if (map.containsKey(key))
            return map.get(key);
        for (int i = 1; i < len; i++) {
            int j = len - i;
            a[s1.charAt(i - 1) - 'a']++;
            b[s2.charAt(i - 1) - 'a']++;
            c[s2.charAt(j) - 'a']++;
            if (Arrays.equals(a, b) && solve(s1.substring(0, i), s2.substring(0, i))
                    && solve(s1.substring(i), s2.substring(i))) {
                map.put(key, true);
                return true;
            }
            if (Arrays.equals(a, c) && solve(s1.substring(0, i), s2.substring(len - i))
                    && solve(s1.substring(i), s2.substring(0, len - i))) {
                map.put(key, true);
                return true;
            }
        }
        map.put(key, false);
        return false;
    }

    public boolean isScramble(String s1, String s2) {
        map = new HashMap<>();
        return solve(s1, s2);
    }
}
