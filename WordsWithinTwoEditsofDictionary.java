import java.util.*;

public class WordsWithinTwoEditsofDictionary {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> res = new ArrayList<>();
        for (String str : queries)
            if (isPossible(str, dictionary))
                res.add(str);
        return res;
    }

    private boolean isPossible(String str, String[] dictionary) {
        char[] arr = str.toCharArray();
        for (String word : dictionary) {
            int count = 0;
            char[] wordArr = word.toCharArray();
            int n = wordArr.length;
            for (int i = 0; i < n; i++)
                if (arr[i] != wordArr[i])
                    count++;
            if (count <= 2)
                return true;
        }
        return false;
    }
}
