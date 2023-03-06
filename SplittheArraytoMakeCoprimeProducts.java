public class SplittheArraytoMakeCoprimeProducts {
    private void findPrimeFactors(int n, int factorArr[], int index) {
        while (n % 2 == 0) {
            factorArr[2] = Math.max(index, factorArr[2]);
            n /= 2;
        }
        int sqrt = (int) Math.sqrt(n);
        for (int i = 3; i <= sqrt; i++) {
            while (n % i == 0) {
                factorArr[i] = Math.max(index, factorArr[i]);
                n /= i;
            }
        }
        if (n > 1)
            factorArr[n] = Math.max(index, factorArr[n]);
    }

    private int findMaxFaink(int n, int factorArr[]) {
        int maxIndex = 0;
        while (n % 2 == 0) {
            maxIndex = Math.max(factorArr[2], maxIndex);
            n /= 2;
        }
        int sqrt = (int) Math.sqrt(n);
        for (int i = 3; i <= sqrt; i++) {
            while (n % i == 0) {
                maxIndex = Math.max(factorArr[i], maxIndex);
                n /= i;
            }
        }
        if (n > 1)
            maxIndex = Math.max(factorArr[n], maxIndex);
        return maxIndex;
    }

    public int findValidSplit(int[] nums) {
        int factorArr[] = new int[1000001];
        for (int i = 0; i < nums.length; i++) {
            findPrimeFactors(nums[i], factorArr, i);
        }
        int fainkIndex = 0, i = 0;
        while (i <= fainkIndex) {
            fainkIndex = Math.max(fainkIndex, findMaxFaink(nums[i], factorArr));
            i++;
        }
        return fainkIndex == nums.length - 1 ? -1 : fainkIndex;
    }
}
