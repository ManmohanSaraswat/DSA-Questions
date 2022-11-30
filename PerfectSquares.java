import java.util.*;

public class PerfectSquares {
    private static int bfs(int n){
        Queue<int[]> queue = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        queue.offer(new int[]{n, 0});
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            if(cur[0] == 0) return cur[1];
            for(int i = 1; i * i <= cur[0]; i++){
                if(map.containsKey(cur[0] - i * i)) continue;
                queue.offer(new int[]{cur[0] - i * i, cur[1] + 1});
                map.put(cur[0] - i * i, cur[1] + 1);
            }
        }
        return -1;
    }
    public int numSquaresNotEfficient(int n) {
        return bfs(n);
    }

    public int numSquaresEfficient(int n){
        int dp[] = new int[n + 1];
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            int min = Integer.MAX_VALUE;
            for(int j = 1; j * j <= i; j++){
                min = Math.min(min, 1 + dp[i - j *j]);
            }
            dp[i] = min;
        }
        return dp[n];
    }
}
