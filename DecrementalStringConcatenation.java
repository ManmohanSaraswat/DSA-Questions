public class DecrementalStringConcatenation {
    Integer[][][] dp;

    private int solve(String words[], int n, char first, char last) {
        if (n == words.length)
            return 0;
        int a = 1000000, b = 1000000;
        if (dp[n][first - 'a'][last - 'a'] != null)
            return dp[n][first - 'a'][last - 'a'];
        if (last == words[n].charAt(0))
            a = words[n].length() - 1 + solve(words, n + 1, first, words[n].charAt(words[n].length() - 1));
        else
            a = words[n].length() + solve(words, n + 1, first, words[n].charAt(words[n].length() - 1));

        if (first == words[n].charAt(words[n].length() - 1))
            b = words[n].length() - 1 + solve(words, n + 1, words[n].charAt(0), last);
        else
            b = words[n].length() + solve(words, n + 1, words[n].charAt(0), last);
        return dp[n][first - 'a'][last - 'a'] = Math.min(a, b);

    }

    public int minimizeConcatenatedLength(String[] words) {
        dp = new Integer[words.length][26][26];
        return words[0].length() + solve(words, 1, words[0].charAt(0), words[0].charAt(words[0].length() - 1));
    }
}
