public class MergeStringsAlternately {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder res = new StringBuilder();
        int n = 0, m = 0;
        while (n < word1.length() || m < word2.length()) {
            if (n < word1.length()) {
                res.append(word1.charAt(n));
                n++;
            }
            if (m < word2.length()) {
                res.append(word2.charAt(m));
                m++;
            }
        }
        return res.toString();
    }
}
