import java.util.*;
import java.util.stream.Collectors;

public class WordSearchII {
    private static class Trie {
        Trie[] next;
        String word;

        public Trie() {
            this.next = new Trie[26];
            this.word = null;
        }
    }

    public void insertWord(Trie trie, String word) {
        char[] chars = word.toCharArray();
        for (char ch : chars) {
            if (trie.next[ch - 'a'] == null)
                trie.next[ch - 'a'] = new Trie();
            trie = trie.next[ch - 'a'];
        }
        trie.word = word;
    }

    private Trie trie;
    private Set<String> res;

    private void dfs(char[][] board, int i, int j, Trie trie, boolean[][] traversed) {
        if (trie.word != null)
            res.add(trie.word);
        if (i < 0 || j < 0 || i == board.length || j == board[0].length || traversed[i][j])
            return;
        if (trie.next[board[i][j] - 'a'] == null)
            return;
        trie = trie.next[board[i][j] - 'a'];
        traversed[i][j] = true;
        dfs(board, i + 1, j, trie, traversed);
        dfs(board, i - 1, j, trie, traversed);
        dfs(board, i, j - 1, trie, traversed);
        dfs(board, i, j + 1, trie, traversed);
        traversed[i][j] = false;
    }

    public List<String> findWords(char[][] board, String[] words) {
        trie = new Trie();
        for (String word : words)
            insertWord(trie, word);
        res = new HashSet<>();
        int n = board.length, m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (trie.next[board[i][j] - 'a'] != null) {
                    dfs(board, i, j, trie, new boolean[n][m]);
                }
            }
        }
        return res.stream().collect(Collectors.toList());
    }
}
