import java.util.*;

public class FindClosestNodetoGivenTwoNodes {
    private int[] bfs(int[] graph, int node){
        Queue<int[]> que = new LinkedList<>();
        int[] res = new int[graph.length];
        Arrays.fill(res, -1);
        que.add(new int[]{node, 0});
        boolean[] visited = new boolean[graph.length];
        while(!que.isEmpty()){
            int cur[] = que.poll();
            res[cur[0]] = cur[1];
            visited[cur[0]] = true;
            int neighbour = graph[cur[0]];
            if(neighbour != -1 && !visited[neighbour])
                que.add(new int[]{neighbour, cur[1] + 1});
        }
        return res;
    }
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int[] m1 = bfs(edges, node1);
        int[] m2 = bfs(edges, node2);
        int maxDistance = Integer.MAX_VALUE;
        for(int i = 0; i < m1.length; i++){
            if(Math.min(m1[i], m2[i]) != -1){
                maxDistance = Math.min(maxDistance, Math.max(m1[i], m2[i]));
            }
        }
        for(int i = 0; i < m1.length; i++){
            if(Math.max(m1[i], m2[i]) == maxDistance) return i;
        }
        return -1;
    }
}
