public class MinimumPenaltyforaShop {
    public int bestClosingTime(String customers) {
        char[] arr = customers.toCharArray();
        int n = arr.length;
        int brr[] = new int[arr.length], crr[] = new int[arr.length];
        if(arr[0] == 'N') brr[0] = 1;
        if(arr[arr.length - 1] == 'Y') crr[crr.length - 1] = 1;
        for(int i = 1; i < arr.length; i++){
            brr[i] = brr[i - 1] + (arr[i] == 'N' ? 1 : 0);
        }
        for(int i = arr.length - 2; i >= 0; i--){
            crr[i] = crr[i + 1] + (arr[i] == 'Y' ? 1 : 0);
        }
        int res = brr[n-1], hr = n;
        for(int i = arr.length - 2; i >= 0; i--){
            if(res >= brr[i] + crr[i + 1]){
                hr = i + 1;
                res = brr[i] + crr[i + 1];
            }
        }
        if(crr[0] <= res) return 0;
        return hr;
    }
}
