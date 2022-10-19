public class FairDistributionOfCookies {
    int finalAns;

    public void solve(int[] cookies, int k, int n, int[] everyChild) {
        if (cookies.length == n) {
            int max = Integer.MIN_VALUE;
            for (int i : everyChild)
                max = Math.max(i, max);
            finalAns = Math.min(finalAns, max);
            return;
        }
        for (int i = 0; i < k; i++) {
            everyChild[i] += cookies[n];
            solve(cookies, k, n + 1, everyChild);
            everyChild[i] -= cookies[n];
        }
    }

    public int distributeCookies(int[] cookies, int k) {
        finalAns = Integer.MAX_VALUE;
        solve(cookies, k, 0, new int[k]);
        return finalAns;
    }
}
