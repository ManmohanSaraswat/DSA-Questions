public class CounttheNumberofSquareFreeSubsets {
    int mod = 1000000007;
    Integer[][] dp;
    int[] factors = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
    private int findPrimeFactors(int num, int bit){
        while(num % 2 == 0){
            if((bit & (1 << 0)) != 0) return -1;
            bit = bit ^ (1 << 0);
            num /= 2;
        }
        for(int i = 1; i <= 9; i++){
            while(num % factors[i] == 0){
                if((bit & (1 << i)) != 0) return -1;
                bit = bit ^ (1 << i);
                num /= factors[i];
            }
        }
        return bit;
    }
    private int solve(int[] arr, int n, int bit){
        if(n == arr.length){
            return 1;
        }
        if(dp[n][bit] != null) return dp[n][bit];
        int merge = findPrimeFactors(arr[n], bit), res = 0;
        if(merge == -1){
            res = solve(arr, n + 1, bit) % mod;
        }else
            res = (solve(arr, n + 1, bit) % mod + solve(arr, n + 1, merge) % mod) % mod;
        return dp[n][bit] = res;
    }
    public int squareFreeSubsets(int[] nums) {
        dp = new Integer[nums.length][1025];
        int res = solve(nums, 0, 0) % mod;
        if(res == 0) return mod - 1;
        return (res - 1 % mod) % mod;
    }
}
