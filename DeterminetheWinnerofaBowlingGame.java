public class DeterminetheWinnerofaBowlingGame {
    public int isWinner(int[] player1, int[] player2) {
        int p1 = 0, p2 = 0, prev[] = new int[2];
        for (int i = 0; i < player1.length; i++) {
            if (prev[0] != 10 && prev[1] != 10)
                p1 += player1[i];
            else
                p1 += 2 * player1[i];
            prev[0] = prev[1];
            prev[1] = player1[i];
        }
        prev[0] = prev[1] = 0;
        for (int i = 0; i < player2.length; i++) {
            if (prev[0] != 10 && prev[1] != 10)
                p2 += player2[i];
            else
                p2 += 2 * player2[i];
            prev[0] = prev[1];
            prev[1] = player2[i];
        }
        if (p1 == p2)
            return 0;
        if (p1 > p2)
            return 1;
        return 2;
    }
}
