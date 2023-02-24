public class FindthePivotInteger {
    public int pivotInteger(int n) {
        int sum = (n * (n + 1)) / 2;
        for(int i = 1; i <= n; i++){
            int tmpSum = (i * (i + 1)) / 2;
            if(tmpSum == sum - tmpSum + i) return i;
        }
        return -1;
    }
}
