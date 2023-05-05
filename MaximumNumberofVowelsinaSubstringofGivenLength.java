public class MaximumNumberofVowelsinaSubstringofGivenLength {
    public int maxVowels(String s, int k) {
        int cur = 0, max = 0;
        for (int i = 0; i < s.length(); i++) {
            if ("aeiou".indexOf(s.charAt(i)) > -1)
                cur++;
            if (i >= k && "aeiou".indexOf(s.charAt(i - k)) > -1)
                cur--;
            max = Math.max(max, cur);
        }
        return max;
    }
}