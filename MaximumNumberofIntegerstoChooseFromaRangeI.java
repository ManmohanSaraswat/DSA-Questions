public class MaximumNumberofIntegerstoChooseFromaRangeI {
    public int maxCount(int[] banned, int n, int maxSum) {
        boolean[] visited = new boolean[10001];
        for(int i: banned) visited[i] = true;
        int sum = 0, count = 0;
        for(int i = 1; i <= n; i++){
            if(visited[i]) continue;
            if(sum + i > maxSum) return count;
            sum += i;
            count ++;
        }
        return count;
    }
}
