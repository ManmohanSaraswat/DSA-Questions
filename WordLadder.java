import java.util.*;
import java.util.stream.Collectors;

public class WordLadder {
    static class Pair {
        String word;
        int level;

        public Pair(String word, int level) {
            this.word = word;
            this.level = level;
        }
    }

    Set<String> set;

    private int solve(String start, String end) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(start, 1));
        Set<String> visited = new HashSet<>();
        while (queue.isEmpty() == false) {
            Pair pair = queue.poll();
            if (end.equals(pair.word))
                return pair.level;
            char[] arr = pair.word.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < 26; j++) {
                    char ch = (char) ('a' + j);
                    if (ch == arr[i])
                        continue;
                    char temp = arr[i];
                    arr[i] = ch;
                    String str = new String(arr);
                    if (set.contains(str) && visited.add(str)) {
                        queue.add(new Pair(str, pair.level + 1));
                    }
                    arr[i] = temp;
                }
            }
        }
        return 0;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        set = wordList.stream().collect(Collectors.toSet());
        return solve(beginWord, endWord);
    }
}
