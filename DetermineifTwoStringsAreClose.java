import java.util.*;
import java.util.stream.IntStream;

public class DetermineifTwoStringsAreClose{
    public boolean closeStrings(String word1, String word2) {
        char[] arr = word1.toCharArray();
        char[] brr = word2.toCharArray();
        int set[] = new int[26], mapOfArr[] = new int[26], mapOfBrr[] = new int[26];;
        IntStream.range(0, arr.length).forEach(i -> set[arr[i] - 'a'] ++);
        if(IntStream.range(0, brr.length).anyMatch(i -> set[brr[i] - 'a'] == 0))
            return false;
            
        IntStream.range(0, arr.length).forEach(i -> mapOfArr[arr[i] - 'a'] ++);
        IntStream.range(0, brr.length).forEach(i -> mapOfBrr[brr[i] - 'a'] ++);

        Arrays.sort(mapOfArr);
        Arrays.sort(mapOfBrr);
        return !IntStream.range(0, 26).anyMatch(i -> mapOfArr[i] != mapOfBrr[i]);
    }
}