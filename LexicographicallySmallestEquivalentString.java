public class LexicographicallySmallestEquivalentString {
    int[] set;

    private int findParent(int u) {
        if (set[u] == u)
            return u;
        return set[u] = findParent(set[u]);
    }

    private void union(int a, int b) {
        int p1 = findParent(a);
        int p2 = findParent(b);
        if (p1 != p2) {
            set[b] = p1;
        }
        if (p1 < p2)
            set[p2] = p1;
        else
            set[p1] = p2;
    }

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        set = new int[26];
        char[] arr = s1.toCharArray();
        char[] brr = s2.toCharArray();
        char[] crr = baseStr.toCharArray();
        for (int i = 0; i < 26; i++)
            set[i] = i;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < brr[i])
                union(arr[i] - 'a', brr[i] - 'a');
            else
                union(brr[i] - 'a', arr[i] - 'a');
        }
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < crr.length; i++) {
            str.append((char) (findParent(crr[i] - 'a') + 'a'));
        }
        return str.toString();
    }
}
