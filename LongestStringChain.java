import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestStringChain {
    private boolean isPredecessor(char[] a, char[] b) {
        boolean diff = false;
        int i = 0, j = 0;
        while (i < a.length && j < b.length) {
            if (a[i] == b[j]) {
                i++;
                j++;
            } else {
                if (diff)
                    return false;
                j++;
                diff = true;
            }
        }
        return true;
    }

    public int longestStrChain(String[] words) {
        int dp[] = new int[words.length], max = 0;
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        for (int i = 0; i < words.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if(words[j].length() + 1 != words[i].length()) continue;
                char[] a = words[j].toCharArray();
                char[] b = words[i].toCharArray();
                if (isPredecessor(a, b)) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
                
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public int longestStrChainEfficient(String[] words) {
        Map<String, Integer> dp = new HashMap<>();
        int max = 0;
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        for (int i = 0; i < words.length; i++) {
            int ans = 0;
            for(int j = 0; j < words[i].length(); j++){
                String toFind = words[i].substring(0, j) + words[i].substring(j + 1);
                ans = Math.max(ans, dp.getOrDefault(toFind, 0) + 1);
            }
            dp.put(words[i], ans);
            max = Math.max(max, ans);
        }
        return max;
    }
}