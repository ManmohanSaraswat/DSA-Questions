import java.util.*;

public class LongestPalindromebyConcatenatingTwoLetterWords {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        Arrays.stream(words).forEach(word -> map.put(word, map.getOrDefault(word, 0) + 1));
        int count = 0, sEq = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String rev = entry.getKey().charAt(1) + "" + entry.getKey().charAt(0);
            if (rev.equals(entry.getKey())) {
                int c = map.get(rev);
                if (c % 2 == 1)
                    sEq++;
                count += c * 2;
            } else
                count += Math.min(entry.getValue(), map.getOrDefault(rev, 0)) * 2;
        }
        if (sEq > 0)
            count -= (sEq - 1) * 2;
        return count;
    }
}
