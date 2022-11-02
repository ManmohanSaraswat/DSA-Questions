import java.util.*;
import java.util.stream.Collectors;

public class MinimumGeneticMutation {
    Set<String> set;
    List<Character> mutations = Arrays.asList('A', 'C', 'G', 'T');
    Map<String, Integer> map;

    private int solve(String start, String end, String[] bank) {
        Queue<Map.Entry<String, Integer>> queue = new LinkedList<>();
        queue.add(Map.entry(start, 0));
        Set<String> visited = new HashSet<>();
        while (queue.isEmpty() == false) {
            Map.Entry<String, Integer> pair = queue.poll();
            if (end.equals(pair.getKey()))
                return pair.getValue();
            char[] a = pair.getKey().toCharArray();
            for (int i = 0; i < 8; i++) {
                for (char ch : mutations) {
                    if (ch == a[i])
                        continue;
                    char temp = a[i];
                    a[i] = ch;
                    String str = new String(a);
                    if (set.contains(str) && visited.add(str)) {
                        queue.add(Map.entry(str, pair.getValue() + 1));
                    }
                    a[i] = temp;
                }
            }
        }
        return -1;
    }

    public int minMutation(String start, String end, String[] bank) {
        map = new HashMap<>();
        set = Arrays.stream(bank).collect(Collectors.toSet());
        return solve(start, end, bank);
    }
}
