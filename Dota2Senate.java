import java.util.*;

public class Dota2Senate {
    public String predictPartyVictory(String senate) {
        char[] arr = senate.toCharArray();
        Queue<Integer> R = new LinkedList<>(), D = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'R')
                R.add(i);
            else
                D.add(i);
        }
        while (R.size() > 0 && D.size() > 0) {
            int a = R.poll(), b = D.poll();
            if (a < b) {
                R.add(a + arr.length);
            } else {
                D.add(b + arr.length);
            }
        }
        return R.size() > 0 ? "Radiant" : "Dire";
    }
}
