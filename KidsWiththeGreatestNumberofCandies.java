import java.util.*;

public class KidsWiththeGreatestNumberofCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for (int candi : candies) {
            max = Math.max(candi, max);
        }
        List<Boolean> res = new ArrayList<>();
        for (int candi : candies) {
            if (candi + extraCandies >= max)
                res.add(true);
            else
                res.add(false);
        }
        return res;
    }
}
