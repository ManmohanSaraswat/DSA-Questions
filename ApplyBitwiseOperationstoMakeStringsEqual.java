public class ApplyBitwiseOperationstoMakeStringsEqual {
    public boolean makeStringsEqual(String s, String target) {
        int a[] = new int[2], b[] = new int[2];
        char[] arr = s.toCharArray();
        char[] brr = target.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            a[arr[i] - '0']++;
            b[brr[i] - '0']++;
        }
        if ((b[0] == arr.length && a[1] > 0) || (a[0] == arr.length && b[1] > 0))
            return false;
        return true;
    }
}
