public class MinimumTimeToMakeTheRopeColorful {
    public int minCost(String colors, int[] neededTime) {
        int n = colors.length(), res = 0, sum = 0, max = 0;
        for(int i = 1; i < n; i++){
            if(colors.charAt(i) == colors.charAt(i-1)){
                if(sum == 0){
                    max = neededTime[i-1];
                    sum = neededTime[i-1];
                }
                sum += neededTime[i];
                max = Math.max(max, neededTime[i]);
            }else{
                res += Math.abs(sum - max);
                sum = 0;
                max = 0;
            }
        }
        if(sum != 0) res += Math.abs(sum - max);
        return res;
    }
}
