public class LongestSubarrayOf1sAfterDeletingOneElement {
    public int longestSubarrayPrefixSuffixArray(int[] nums) {
        int n = nums.length, prefix[] = new int[nums.length], suffix[] = new int[nums.length], ans = 0;
        prefix[0] = nums[0];
        suffix[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++)
            if (nums[i] == 1)
                prefix[i] = prefix[i - 1] + 1;
        for(int i = n - 2; i >= 0; i--)
            if(nums[i] == 1)
                suffix[i] = suffix[i + 1] + 1;
        ans = Math.max(suffix[1], prefix[n-2]);
        for(int i = 1; i < n - 1; i++)
            ans = Math.max(ans, prefix[i-1] + suffix[i+1]);
        return ans;
    }
    public int longestSubarrayEfficientApproach(int[] nums) {
        int index = 0, lastOnes = 0, nextOnes = 0, ans = 0, n = nums.length, res = 0;
        for(int i : nums) res += i;
        if(res == 0) return 0;
        if(res == n) return n - 1;
        while(index < n && nums[index] == 1){
            index ++;
            lastOnes ++;
        }
        while(index < n){
            if(nums[index] == 0){
                index ++;
                while(index < n && nums[index] != 0){
                    nextOnes ++;
                    index ++;
                }
                ans = Math.max(ans, lastOnes + nextOnes);
                lastOnes = nextOnes;
                nextOnes = 0;
            }else
                index ++;
        }
        return ans;
    }

    public int longestSubarrayMostEfficientApproach(int[] nums) {
        int low = 0, high = 0, countZero = 0, ans = 0;
        for(;high < nums.length; high ++){
            int element = nums[high];
            if(element == 0){
                countZero ++;
                while(countZero > 1){
                    if(nums[low] == 0) countZero --;
                    low ++;
                }
            }
            ans = Math.max(ans, high - low);
        }
        return ans;
    }
}