import java.util.Arrays;

public class SuccessfulPairsofSpellsandPotions {
    private int solve(int spell, int[] potion, long success) {
        int start = 0, end = potion.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (potion[mid] * 1L * spell >= success) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return potion.length - start;
    }

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int res[] = new int[spells.length];
        for (int i = 0; i < spells.length; i++) {
            res[i] = solve(spells[i], potions, success);
        }
        return res;
    }
}
