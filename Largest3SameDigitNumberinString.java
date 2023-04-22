import java.util.*;

public class Largest3SameDigitNumberinString {
    public String largestGoodInteger(String num) {
        List<String> strs = Arrays.asList("999", "888", "777", "666", "555", "444", "333", "222", "111", "000");
        for (String str : strs) {
            if (num.contains(str))
                return str;
        }
        return "";
    }
}
