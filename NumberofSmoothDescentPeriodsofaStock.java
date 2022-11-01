public class NumberofSmoothDescentPeriodsofaStock {
    public long getDescentPeriods(int[] prices) {
        long count = 0, cons = 1;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] - prices[i] == 1) {
                cons++;
            } else {
                count += (cons * (cons + 1)) / 2;
                cons = 1;
            }
        }
        count += (cons * (cons + 1)) / 2;
        return count;
    }
}
