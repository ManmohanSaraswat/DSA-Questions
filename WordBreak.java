import java.util.*;

public class WordBreak {
    static class Trie {
        boolean isWord;
        Trie[] next;

        public Trie() {
            this.next = new Trie[26];
            isWord = false;
        }
    }

    Trie trie;
    Map<String, Boolean> dp;

    public boolean contains(String word) {
        char[] arr = word.toCharArray();
        Trie temp = trie;
        for (int i = 0; i < arr.length; i++) {
            if (temp.next[arr[i] - 'a'] == null)
                return false;
            temp = temp.next[arr[i] - 'a'];
        }
        return temp.isWord;
    }

    public boolean contains(StringBuilder word) {
        return contains(word.toString());
    }

    public void insert(String word) {
        char[] arr = word.toCharArray();
        Trie temp = trie;
        for (int i = 0; i < arr.length; i++) {
            if (temp.next[arr[i] - 'a'] == null)
                temp.next[arr[i] - 'a'] = new Trie();
            temp = temp.next[arr[i] - 'a'];
        }
        temp.isWord = true;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        trie = new Trie();
        dp = new HashMap<>();
        for (String word : wordDict)
            insert(word);
        return solve(s);
    }

    private boolean solve(String str) {
        if (str.length() == 0)
            return true;
        if (dp.containsKey(str))
            return dp.get(str);
        StringBuilder s = new StringBuilder();
        char[] arr = str.toCharArray();
        boolean res = false;
        for (int i = 0; i < arr.length; i++) {
            s.append(arr[i]);
            if (contains(s))
                res = res || solve(str.substring(i + 1, arr.length));
        }
        dp.put(str, res);
        return res;
    }
}
