public class WaysToMakeAFairArray {
    public int waysToMakeFair(int[] nums) {
        if(nums.length == 1) return 1;
        int n = nums.length, count = 0;
        int []evenLeft = new int[n];
        int []evenRight = new int[n];
        int []oddLeft = new int[n];
        int []oddRight = new int[n];
        
        evenLeft[0] = nums[0];
        for(int i = 1; i < n; i++){
            if((i & 1) == 0) {
                evenLeft[i] = nums[i] + evenLeft[i-1];
                oddLeft[i] = oddLeft[i-1];
            }
            else{
                evenLeft[i] = evenLeft[i-1];
                oddLeft[i] = nums[i] + oddLeft[i-1];
            }
        }
        if(((n-1) & 1) == 0) evenRight[n-1] = nums[n-1];
        else oddRight[n-1] = nums[n-1]; 
        for(int i = n-2; i >= 0; i--){
            if((i & 1) == 0) {
                evenRight[i] = nums[i] + evenRight[i+1];
                oddRight[i] = oddRight[i+1];
            }
            else {
                oddRight[i] = nums[i] + oddRight[i+1];
                evenRight[i] = evenRight[i+1];
            }
        }
        if(oddRight[1] == evenRight[1]) count ++;
        if(oddLeft[n-2] == evenLeft[n-2]) count ++;
        for(int i = 1; i < n-1; i++){
            if(oddLeft[i-1]+evenRight[i+1] == evenLeft[i-1] + oddRight[i+1]) count ++;
        }
        return count;
    }
}
