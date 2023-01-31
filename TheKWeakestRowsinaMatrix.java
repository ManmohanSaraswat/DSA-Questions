import java.util.PriorityQueue;
import java.util.Queue;

public class TheKWeakestRowsinaMatrix {
    public int[] kWeakestRows(int[][] mat, int k) {
        Queue<int[]> que = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        for(int i = 0; i < mat.length; i++){
            int count = 0;
            for(int j = 0; j < mat[i].length; j++){
                if(mat[i][j] == 1) count ++;
                else break;
            }
            que.offer(new int[]{i, count});
        }
        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = que.poll()[0];
        }
        return res;
    }
}
