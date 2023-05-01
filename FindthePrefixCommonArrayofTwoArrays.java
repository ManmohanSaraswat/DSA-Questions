public class FindthePrefixCommonArrayofTwoArrays {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int res[] = new int[A.length];
        int[] map = new int[51];
        int[] mapB = new int[51];
        for (int i = 0; i < A.length; i++) {
            map[A[i]]++;
            mapB[B[i]]++;
            int count = 0;
            for (int j = 1; j < 51; j++) {
                if (map[j] > 0 && map[j] == mapB[j])
                    count++;
            }
            res[i] = count;
        }
        return res;
    }
}
