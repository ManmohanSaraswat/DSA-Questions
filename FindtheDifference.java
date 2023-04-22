public class FindtheDifference {
    public char findTheDifference(String s, String t) {
        char[] arr = s.toCharArray();
        char[] brr = t.toCharArray();
        int[] crr = new int[26];
        int[] drr = new int[26];
        for (int i = 0; i < arr.length; i++)
            crr[arr[i] - 'a']++;
        for (int i = 0; i < brr.length; i++)
            drr[brr[i] - 'a']++;
        for (int i = 0; i < 26; i++)
            if (crr[i] != drr[i])
                return (char) ('a' + i);
        return 'a';
    }
}
