import java.util.*;

public class KeysandRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> que = new LinkedList<>();
        boolean[] visited = new boolean[rooms.size()];
        visited[0] = true;
        que.offer(0);
        while (!que.isEmpty()) {
            int room = que.poll();
            List<Integer> r = rooms.get(room);
            for (Integer cr : r) {
                if (!visited[cr]) {
                    que.offer(cr);
                    visited[cr] = true;
                }
            }
        }
        for (boolean r : visited) {
            if (!r)
                return false;
        }
        return true;
    }
}
