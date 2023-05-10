public class GreatestEnglishLetterinUpperandLowerCase {
    public String greatestLetter(String s) {
        int[] arr = new int[26];
        int[] brr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                arr[ch - 'a']++;
            } else {
                brr[ch - 'A']++;
            }
        }
        int ans = -1;
        for (int i = 0; i < 26; i++) {
            if (arr[i] > 0 && brr[i] > 0)
                ans = i;
        }
        return ans == -1 ? "" : "" + (char) ('A' + ans);
    }
}
