public class NeighboringBitwiseXOR {
    public boolean doesValidArrayExist(int[] derived) {
        int n = derived.length;
        int[] org1 = new int[n];
        org1[0] = 1;
        for (int i = 0; i < n - 1; i++) {
            org1[i + 1] = derived[i] ^ org1[i];
        }
        if ((org1[0] ^ org1[n - 1]) == derived[n - 1])
            return true;
        org1[0] = 0;
        for (int i = 0; i < n - 1; i++) {
            org1[i + 1] = derived[i] ^ org1[i];
        }
        if ((org1[0] ^ org1[n - 1]) == derived[n - 1])
            return true;
        return false;
    }
}
