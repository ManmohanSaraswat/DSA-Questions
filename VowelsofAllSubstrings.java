public class VowelsofAllSubstrings {
    public long countVowels(String word) {
        char[] arr = word.toCharArray();
        int n = arr.length;
        long res = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u')
                res += (i + 1L) * (n - i);
        }
        return res;
    }
}
