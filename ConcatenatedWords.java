import java.util.*;

public class ConcatenatedWords {
    static class Trie {
        boolean isWord;
        Trie[] next;

        Trie() {
            isWord = false;
            next = new Trie[26];
        }
    }

    Trie trie;

    private void addWord(char[] arr) {
        Trie temp = trie;
        for (int i = 0; i < arr.length; i++) {
            if (temp.next[arr[i] - 'a'] == null)
                temp.next[arr[i] - 'a'] = new Trie();
            temp = temp.next[arr[i] - 'a'];
        }
        temp.isWord = true;
    }

    private boolean containsWord(char[] arr, int start) {
        Trie temp = trie;
        int i;
        for (i = start; i < arr.length; i++) {
            if (temp.isWord) {
                if (containsWord(arr, i))
                    return true;
            }
            if (temp.next[arr[i] - 'a'] != null) {
                temp = temp.next[arr[i] - 'a'];
            } else
                break;
        }
        return i == arr.length && temp.isWord;
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        trie = new Trie();
        char[][] arr = new char[words.length][];
        for (int i = 0; i < words.length; i++) {
            arr[i] = words[i].toCharArray();
        }
        Arrays.sort(arr, (a, b) -> a.length - b.length);
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (containsWord(arr[i], 0))
                ans.add(new String(arr[i]));
            addWord(arr[i]);
        }
        return ans;
    }
}