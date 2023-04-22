public class KItemsWiththeMaximumSum {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        if (numOnes >= k)
            return k;
        int res = numOnes;
        k -= numOnes;
        if (numZeros >= k)
            return res;
        k -= numZeros;
        return res + k * -1;
    }
}
