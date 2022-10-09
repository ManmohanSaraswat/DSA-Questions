public class StoneGame {
    public boolean find(int start, int end, boolean alice) {
        if (end - start == 1) {
            if (alice)
                return true;
            return false;
        }
        return find(start + 1, end, !alice) || find(start, end - 1, !alice);

    }

    public boolean stoneGame(int[] piles) {
        return find(0, piles.length-1, true);
        // return true;
    }
}