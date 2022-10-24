import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MaximumLengthOfAConcatnatedStringFormedByUniqueCharacters {
    private int solve(List<String> arr, int n, boolean[] visited) {
        if (n == arr.size())
            return 0;
        String str = arr.get(n);
        int ans = 0;
        if (isUniqueString(str) && isConcatenationUnique(str, visited)) {
            concatenateString(str, visited);
            ans = str.length() + solve(arr, n + 1, visited); // le lia
            deConcatenateString(str, visited);
        }
        ans = Math.max(ans, solve(arr, n + 1, visited)); // nai lia
        return ans;
    }

    private boolean isUniqueString(String str) {
        Set<Character> set = new HashSet<>();

        for (char ch : str.toCharArray())
            if (!set.add(ch))
                return false;
        return true;
    }

    private void deConcatenateString(String str, boolean[] visited) {
        for (char ch : str.toCharArray())
            visited[ch - 'a'] = false;
    }

    private void concatenateString(String str, boolean[] visited) {
        for (char ch : str.toCharArray())
            visited[ch - 'a'] = true;
    }

    private boolean isConcatenationUnique(String str, boolean[] visited) {
        for (char ch : str.toCharArray()) {
            if (visited[ch - 'a'])
                return false;
        }
        return true;
    }

    public int maxLength(List<String> arr) {
        return solve(arr, 0, new boolean[26]);
    }
}

class MaximumLengthOfAConcatnatedStringFormedByUniqueCharactersWithBitManipulation {
    int bitMask;

    private int solve(List<String> arr, int n) {
        if (n == arr.size())
            return 0;
        String str = arr.get(n);
        int ans = 0;
        if (isUniqueString(str) && isConcatenationUnique(str)) {
            concatenateString(str);
            ans = str.length() + solve(arr, n + 1); // le lia
            deConcatenateString(str);
        }
        ans = Math.max(ans, solve(arr, n + 1)); // nai lia
        return ans;
    }

    private boolean isUniqueString(String str) {
        int bit = 0;

        for (char ch : str.toCharArray()) {
            if ((bit & (1 << (ch - 'a'))) != 0)
                return false;
            bit |= (1 << (ch - 'a'));
        }
        return true;
    }

    private void deConcatenateString(String str) {
        for (char ch : str.toCharArray())
            bitMask ^= (1 << (ch - 'a'));
    }

    private void concatenateString(String str) {
        for (char ch : str.toCharArray())
            bitMask |= (1 << (ch - 'a'));
    }

    private boolean isConcatenationUnique(String str) {
        for (char ch : str.toCharArray()) {
            if ((bitMask & (1 << (ch - 'a'))) != 0)
                return false;
        }
        return true;
    }

    public int maxLength(List<String> arr) {
        return solve(arr, 0);
    }
}