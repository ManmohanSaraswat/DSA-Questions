public class Powxn {
    // public double solve(double x, long n){
    // if(n == 1) return x;
    // if(n % 2 == 0) return solve(x * x, n / 2);
    // return solve(x, n - 1) * x;
    // }
    public double myPow(double x, int n) {
        // if(n == 0 || x == 1) return 1;
        // if(n < 0) return 1 / solve(x, Math.abs(n*1L));
        // return solve(x, Math.abs(n));
        return Math.pow(x, n);
    }
}
