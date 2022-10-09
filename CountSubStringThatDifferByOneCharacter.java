public class CountSubStringThatDifferByOneCharacter {
    public static int countSubstringsTabular(String s, String t) {
        int n = s.length(), m = t.length();
        int[][] equals = new int[n + 1][m + 1];
        int[][] notEquals = new int[n + 1][m + 1];
        int count = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) != t.charAt(j - 1)) {
                    notEquals[i][j] = 1 + equals[i - 1][j - 1];
                } else {
                    equals[i][j] = equals[i - 1][j - 1] + 1;
                    notEquals[i][j] = notEquals[i - 1][j - 1];
                }
                count += notEquals[i][j];
            }
        }
        return count;
    }
    public static void main(String[] args) {
        String s = "aba";
        String t = "baba";
        System.out.println(countSubstringsTabular(s, t));
    }
}
