import java.util.*;

public class ReverseVowelsofaString {

    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        List<Character> lst = new ArrayList<>();
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        for (int i = 0; i < arr.length; i++) {
            if (set.contains(arr[i]))
                lst.add(arr[i]);
        }
        int c = lst.size() - 1;
        for (int i = 0; i < arr.length; i++) {
            if (set.contains(arr[i])) {
                arr[i] = lst.get(c);
                c--;
            }
        }
        return new String(arr);
    }

    public String reverseVowelsOptimized(String s) {
        char[] arr = s.toCharArray();
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        int i = 0, j = arr.length - 1;
        while (i < j) {
            while (i < j && !set.contains(arr[i]))
                i++;
            while (i < j && !set.contains(arr[j]))
                j--;
            if (i >= j)
                break;
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return new String(arr);
    }
}
